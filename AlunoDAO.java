package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

import conexaoBD.Conexao;
import vo.Aluno;


public class AlunoDAO {
	
	public void cadastrar(Aluno aluno) {
		 Connection conn =  null;
		 PreparedStatement ps = null;
		 conn = new Conexao().getConnection();
		
		String sql= "INSERT INTO Aluno(nomeCompleto, nomeUsuario, email, senha)VALUES(?,?,?,?)";
		
		try {
			 ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNomeCompleto());
			ps.setString(2, aluno.getNomeUsuario());
			ps.setString(3, aluno.getEmail());
			ps.setString(4, aluno.getSenha());

			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void adicionarOlimpiadas(Aluno aluno, String olimpiada) {
		Connection conn =  null;
		 PreparedStatement ps = null;
		 conn = new Conexao().getConnection();
		
		 aluno.setOlimpiadasSelecionadas(olimpiada);
		 
		String sql= "INSERT INTO olimpiadasSelecionadas(nome, emailAluno)VALUES(?,?)";
		
		try {
			 ps = conn.prepareStatement(sql);
			ps.setString(1, olimpiada);
			ps.setString(2, aluno.getEmail());

			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList retornaOlimpiadasSelecionadas(Aluno aluno) {
		ArrayList<String> olimpiadas = new ArrayList<String>();

        try {
        	 Connection conn =  null;
    		 PreparedStatement ps = null;
    		 conn = new Conexao().getConnection();
    		 
            String selectQuery = "SELECT * FROM olimpiadasSelecionadas WHERE emailAluno = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, aluno.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	 String nomeOlimp = resultSet.getString("nome");
                 olimpiadas.add(nomeOlimp);
            }
            
            ps.close();
            resultSet.close();
			conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return olimpiadas;
    }
	
	
	public boolean consultar(String email, String senha) {
		 try {
			 Connection conn =  null;
			 PreparedStatement ps = null;
			 conn = new Conexao().getConnection();
			 
			 boolean autenticado = false;
			 String sql="SELECT email, senha FROM Aluno WHERE email=? AND senha=?";
			 
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			
			ResultSet rs=null;
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String emailBD= rs.getString("email");
				String senhaBD= rs.getString("senha");
				autenticado = true;
			}
			ps.close();
			rs.close();
			conn.close();
			return autenticado;
			
		 }catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
			 Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
			 throw new RuntimeException();
		 }
	}
	
	public boolean atualizar(Aluno aluno, String nomeCompleto, String nomeUsuario, String senha, String email) {

        try {
        	Connection conn =  null;
    		conn = new Conexao().getConnection();
    		
    		String sql = "UPDATE Aluno SET nomeCompleto = ?, nomeUsuario = ?, senha=?  WHERE email = ?";
    		
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		
        	stmt.setString(1, nomeCompleto);
			stmt.setString(2, nomeUsuario);
			stmt.setString(3, senha);
			stmt.setString(4, email);
			stmt.executeUpdate();
			
			int linhasAfetadas= stmt.executeUpdate();
			conn.close();
			stmt.close();
			if(linhasAfetadas>0){
	            return true;
			}else {
	            return false;
			}			
			
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean atualizarSenha(Aluno aluno, String senha, String email) {
		try {
        	Connection conn =  null;
    		conn = new Conexao().getConnection();
    		
    		String sql = "UPDATE Aluno SET senha=?  WHERE email = ?";
    		
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		
			stmt.setString(1, senha);
			stmt.setString(2, email);
			stmt.executeUpdate();
			
			int linhasAfetadas= stmt.executeUpdate();

			stmt.close();
			conn.close();
			if(linhasAfetadas>0){
	            return true;
			}else {
	            return false;
			}			
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean remover(String email) {
		try {
			Connection conn =  null;
			conn = new Conexao().getConnection();
			conn.setAutoCommit(false);
			
			Statement statement = conn.createStatement();
	        statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0"); //desativa chaves estrangeiras

	        String sqlExcluirRegistrosRelacionados1 = "DELETE FROM olimpiadasSelecionadas WHERE emailAluno = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlExcluirRegistrosRelacionados1);
            preparedStatement.setString(1, email);

            // Executa a consulta de exclusão dos registros relacionados
            int registrosExcluidos = preparedStatement.executeUpdate();

            
	        String sqlExcluirUsuario = "DELETE FROM Aluno WHERE email = ?";
            // Cria outro objeto PreparedStatement para a consulta de exclusão do usuário principal
            preparedStatement = conn.prepareStatement(sqlExcluirUsuario);
            preparedStatement.setString(1, email);
            int usuarioExcluido = preparedStatement.executeUpdate();
            
            preparedStatement.close();
			conn.close();

            if (registrosExcluidos > 0 && usuarioExcluido > 0) {
                // Confirma a transação se todas as operações foram bem-sucedidas
                conn.commit();
    	        statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");//ativa chaves
                return true;
            } else {
    	        statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");//ativa chaves
            	return false;
            }
	        	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public static Aluno obterAlunoExistente(String email) {
        Aluno aluno = null;

        try {
        	 Connection conn =  null;
    		 PreparedStatement ps = null;
    		 conn = new Conexao().getConnection();
    		 
            String selectQuery = "SELECT * FROM Aluno WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nomeCompleto = resultSet.getString("nomeCompleto");
                String nomeUsuario = resultSet.getString("nomeUsuario");
                String email1 = resultSet.getString("email");
                String senha = resultSet.getString("senha");

                aluno = new Aluno(nomeCompleto, nomeUsuario, email1, senha );
            }
            resultSet.close();
            preparedStatement.close();
			conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }
	
}
