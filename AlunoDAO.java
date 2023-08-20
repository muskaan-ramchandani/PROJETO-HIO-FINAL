package dao;

import java.sql.*;
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
}