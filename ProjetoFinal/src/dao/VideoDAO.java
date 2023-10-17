package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import conexaoBD.Conexao;
import vo.Video;
import vo.Aluno;
import vo.Livro;
import vo.Olimpiada;


public class VideoDAO {
	public boolean cadastrar(Video video, java.util.Date dataPublicacao, File arquivoVideo, Olimpiada olimp) {
		try {
			 Connection conn =  null;
			 PreparedStatement ps = null;
			 conn = new Conexao().getConnection();
			 byte[] videoData;
				try {
					videoData = Files.readAllBytes(arquivoVideo.toPath());
					
					String sql= "INSERT INTO Video(upc, titulo, produtor, dataPublicacao, emailProf, arquivo_Video)VALUES(?,?,?,?,?,?)";
					
					ps = conn.prepareStatement(sql);
					ps.setString(1, video.getUpc());
					ps.setString(2, video.getTitulo());
					ps.setString(3, video.getProdutor());
					ps.setDate(4, (Date) dataPublicacao);
					ps.setString(5, video.getEmailProf());
		            ps.setBytes(6, videoData);					
					
					int  linhasAfetadas= ps.executeUpdate();
		            ps.close();
					conn.close();
					if(linhasAfetadas>0) {
						return true;
					}else {
						return false;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public ArrayList retornaVideoOlimpiada(Olimpiada olimp) {
		ArrayList<Video> videos = new ArrayList<Video>();
        try {
        	 Connection conn =  null;
    		 PreparedStatement ps = null;
    		 conn = new Conexao().getConnection();
    	    
        
         // Consulta SQL para selecionar vídeos com base no nome da Olimpíada
            String sql = "SELECT * FROM Video " +
                         "INNER JOIN OlimpiadaVideo ON Video.upc = OlimpiadaVideo.upcVideo " +
                         "WHERE OlimpiadaVideo.nomeOlimpiada = ?";

            // Preparar a consulta
            ps = conn.prepareStatement(sql);
            ps.setString(1, olimp.getNome());

            // Executar a consulta
            ResultSet resultSet = ps.executeQuery();

            // Processar o resultado
            while (resultSet.next()) {
            	InputStream inputStream = resultSet.getBinaryStream("arquivo_Video");
                File arquivo = criarArquivoAPartirDoBlob(inputStream, resultSet.getString("upc"));
                
				 Video video = new Video(resultSet.getString("titulo"), resultSet.getString("upc"),
						 resultSet.getString("produtor"), resultSet.getDate("dataPublicacao"),
						 resultSet.getString("emailProf"), arquivo);
			    
				 //adiciona o video na lista
			     videos.add(video);
 			}
            resultSet.close();
            ps.close();
			conn.close();
               
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return videos;
    }
	
	//PARA PODER RETORNAR O ARQUIVO
	private File criarArquivoAPartirDoBlob(InputStream inputStream, String upc) throws IOException {
		Connection conn =  null;
		conn = new Conexao().getConnection();
	    File arquivo = null;
	    try {
	        PreparedStatement ps = conn.prepareStatement("SELECT titulo, arquivo_Video FROM Video WHERE upc = ?");
	        ps.setString(1, upc);
	        ResultSet rs = ps.executeQuery();
	        
	        if ( rs.next() ){
	        	byte [] bytes = rs.getBytes("arquivo_Video");
	            String titulo = rs.getString("titulo");

	            //converte o array de bytes em file
	            File diretorioDaAplicacao = new File(System.getProperty("user.dir"));
	            arquivo = new File(diretorioDaAplicacao, "dados/"+titulo+".mp4");

	            FileOutputStream fos = new FileOutputStream(arquivo);
	            fos.write( bytes );
	            fos.close();
	        }
	        rs.close();
            ps.close();
			conn.close();
	} catch (SQLException ex) {
	ex.printStackTrace();
	}
	catch (IOException ex) {
	ex.printStackTrace();
	}
	    return arquivo;
    }
	
	public boolean relacionarComOlimp(Olimpiada olimp, String upc) {
		try {
			 Connection conn =  null;
			 PreparedStatement ps = null;
			 conn = new Conexao().getConnection();
					
			 String sql= "INSERT INTO OlimpiadaVideo(upcVideo, nomeOlimpiada)VALUES(?,?)";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, upc);
				ps.setString(2, olimp.getNome());
				
				int  linhasAfetadas= ps.executeUpdate();
	            ps.close();
				conn.close();
				if(linhasAfetadas>0) {
					return true;
				}else {
					return false;
				}
					
					
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	 
	public ArrayList<Video> consultarVideosPorNome(String tituloVideo, Olimpiada olimp) {
	    ArrayList<Video> videosPorNome = new ArrayList<>();
	    try {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        conn = new Conexao().getConnection();
	        
	        String sql = "SELECT * FROM Video " +
                    "INNER JOIN OlimpiadaVideo ON Video.upc = OlimpiadaVideo.upcVideo " +
                    "WHERE OlimpiadaVideo.nomeOlimpiada = ? AND Video.titulo LIKE ?";


	        // Preparar a consulta
	        ps = conn.prepareStatement(sql);
            ps.setString(1, olimp.getNome());
	        ps.setString(2, "%" + tituloVideo + "%");

	        // Executar a consulta
	        ResultSet resultSet = ps.executeQuery();

	        // Processar o resultado
	        while (resultSet.next()) {
	        	InputStream inputStream = resultSet.getBinaryStream("arquivo_Video");
                File arquivo = criarArquivoAPartirDoBlob(inputStream, resultSet.getString("upc"));
                
				 Video video = new Video(resultSet.getString("titulo"), resultSet.getString("upc"),
						 resultSet.getString("produtor"), resultSet.getDate("dataPublicacao"),
						 resultSet.getString("emailProf"), arquivo);

	            // Adiciona o livro na lista
				 videosPorNome.add(video);
	        }
	        resultSet.close();
            ps.close();
			conn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return videosPorNome;
	}
	
	public ArrayList<Video> consultarVideosPorUpc(String upc, Olimpiada olimp) {
	    ArrayList<Video> videosPorNome = new ArrayList<>();
	    try {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        conn = new Conexao().getConnection();
	        
	        String sql = "SELECT * FROM Video " +
                    "INNER JOIN OlimpiadaVideo ON Video.isbn = OlimpiadaVideo.upcVideo " +
                    "WHERE OlimpiadaVideo.nomeOlimpiada = ? AND Video.upc LIKE ?";


	        // Preparar a consulta
	        ps = conn.prepareStatement(sql);
            ps.setString(1, olimp.getNome());
	        ps.setString(2, upc + "%");

	        // Executar a consulta
	        ResultSet resultSet = ps.executeQuery();

	        // Processar o resultado
	        while (resultSet.next()) {
	        	InputStream inputStream = resultSet.getBinaryStream("arquivo_Video");
                File arquivo = criarArquivoAPartirDoBlob(inputStream, resultSet.getString("upc"));
                
				 Video video = new Video(resultSet.getString("titulo"), resultSet.getString("upc"),
						 resultSet.getString("produtor"), resultSet.getDate("dataPublicacao"),
						 resultSet.getString("emailProf"), arquivo);

	            // Adiciona o livro na lista
	            videosPorNome.add(video);
	        }

	        resultSet.close();
            ps.close();
			conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return videosPorNome;
	}

	public boolean HistoricoVideosProf(String emailProf, String upc, String titulo) {
		try {
			Connection conn = null;
	        PreparedStatement ps = null;
	        conn = new Conexao().getConnection();
	        
	        String sql = "INSERT INTO HistoricoVideosProf (upc, titulo, emailProf) VALUES (?, ?, ?)";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, upc);
	        ps.setString(2, titulo);
	        ps.setString(3, emailProf);

	        int  linhasAfetadas= ps.executeUpdate();
            ps.close();
			conn.close();
			if(linhasAfetadas>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
	        e.printStackTrace();
			return false;

	    }
	}
	
	public ArrayList<String> exibirHistoricoVideosProfUPC(String emailProfessor) {
		ArrayList<String> listaISBNRec = new ArrayList<String>();

        try {
        	Connection conn = null;
	        PreparedStatement ps = null;
	        conn = new Conexao().getConnection();
	        String sql = "SELECT upc, dataAcesso FROM HistoricoVideosProf " +
                         "WHERE emailProf = ? " +
                         "ORDER BY dataAcesso DESC " +
                         "LIMIT 2";
            ps = conn.prepareStatement(sql);
            ps.setString(1, emailProfessor);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String upc = resultSet.getString("upc");
                listaISBNRec.add(upc);
                
            }
            resultSet.close();
            ps.close();
			conn.close();
            
            return listaISBNRec;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
	
	public ArrayList<String> exibirHistoricoVideosProfTITULO(String emailProfessor) {
		ArrayList<String> listaTiTULORec = new ArrayList<String>();

        try {
        	Connection conn = null;
	        PreparedStatement ps = null;
	        conn = new Conexao().getConnection();
	        String sql = "SELECT titulo, dataAcesso FROM HistoricoVideosProf " +
                         "WHERE emailProf = ? " +
                         "ORDER BY dataAcesso DESC " +
                         "LIMIT 2";
            ps = conn.prepareStatement(sql);
            ps.setString(1, emailProfessor);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                listaTiTULORec.add(titulo);
                
            }
            resultSet.close();
            ps.close();
			conn.close();

            return listaTiTULORec;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}
