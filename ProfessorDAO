package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

import conexaoBD.Conexao;
import vo.Aluno;
import vo.Professor;

public class ProfessorDAO {
	
	public void cadastrar(Professor prof) {
		 Connection conn =  null;
		 PreparedStatement ps = null;
		 conn = new Conexao().getConnection();
		
		String sql= "INSERT INTO Professor(nomeCompleto, nomeUsuario, email, senha)VALUES(?,?,?,?)";
		
		try {
			 ps = conn.prepareStatement(sql);
			ps.setString(1, prof.getNomeCompleto());
			ps.setString(2, prof.getNomeUsuario());
			ps.setString(3, prof.getEmail());
			ps.setString(4, prof.getSenha());


			ps.execute();
            ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean consultar(String email, String senha) {
		 try {
			 Connection conn =  null;
			 PreparedStatement ps = null;
			 conn = new Conexao().getConnection();
			 
			 boolean autenticado = false;
			 String sql="SELECT email, senha FROM Professor WHERE email=? AND senha=?";
			 
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
            ps.close();
			conn.close();
			return autenticado;
			
		 }catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
			 Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
			 throw new RuntimeException();
		 }
	}
	
	public boolean atualizar(Professor prof, String nomeCompleto, String nomeUsuario, String senha) {

        try {
        	Connection conn =  null;
    		conn = new Conexao().getConnection();
    		
    		String sql = "UPDATE Professor SET nomeCompleto = ?, nomeUsuario = ?, senha=?  WHERE email = ?";
    		
    		PreparedStatement stmt = conn.prepareStatement(sql);

        	stmt.setString(1, nomeCompleto);
			stmt.setString(2, nomeUsuario);
			stmt.setString(3, senha);
			stmt.setString(4, prof.getEmail());
			
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
	
	public boolean atualizarSenha(Professor prof, String senha, String email) {
		try {
        	Connection conn =  null;
    		conn = new Conexao().getConnection();
    		
    		String sql = "UPDATE Professor SET senha=?  WHERE email = ?";
    		
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
        try{
        	Connection conn =  null;
   		 	conn = new Conexao().getConnection();
   		 	
   	        String sql = "DELETE FROM Professor WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            
            int linhasAfetadas = stmt.executeUpdate();
            stmt.close();
			conn.close();
            if (linhasAfetadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public static Professor obterProfExistente(String email) {
        Professor prof = null;

        try {
        	 Connection conn =  null;
    		 PreparedStatement ps = null;
    		 conn = new Conexao().getConnection();
    		 
            String selectQuery = "SELECT * FROM Professor WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nomeCompleto = resultSet.getString("nomeCompleto");
                String nomeUsuario = resultSet.getString("nomeUsuario");
                String email1 = resultSet.getString("email");
                String senha = resultSet.getString("senha");

                prof = new Professor(nomeCompleto, nomeUsuario, email1, senha );
            }
            resultSet.close();
            preparedStatement.close();
			conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prof;
    }
}
