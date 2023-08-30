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
			return autenticado;
			
		 }catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
			 Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
			 throw new RuntimeException();
		 }
	}
	
	public boolean atualizar(Aluno aluno) {
		Connection conn =  null;
		conn = new Conexao().getConnection();
		
		String sql = "UPDATE Aluno SET nomeCompleto = ?, nomeUsuario = ?, senha=?  WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, aluno.getNomeCompleto());
			stmt.setString(2, aluno.getNomeUsuario());
			stmt.setString(3, aluno.getSenha());
			stmt.setString(4, aluno.getEmail());
			
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean remover(String email) {
		
        String sql = "DELETE FROM Aluno WHERE email = ?";

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            return true;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }
	
}
