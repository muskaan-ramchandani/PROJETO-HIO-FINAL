package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import conexaoBD.Conexao;
import vo.Olimpiada;

public class OlimpiadaDAO {
	
	public boolean consultar(String nome) {
		 boolean autenticado = false;

			try {
				 Connection conn =  null;
				 PreparedStatement ps = null;
				 conn = new Conexao().getConnection();
				 
				 String sql="SELECT nome FROM Olimpiada WHERE nome=?";
				 
				ps = conn.prepareStatement(sql);
				ps.setString(1, nome);
				
				ResultSet rs=null;
				rs=ps.executeQuery();
				
				if(rs.next()) {
					String nomeOlimp= rs.getString("nome");
					autenticado = true;
				}
				ps.close();
				rs.close();
				conn.close();
			 }catch(SQLException e) {
				 autenticado=false;
			 }
			
			return autenticado;
	}
	
	public static Olimpiada obterOlimpiadaExistente(String nome) {
		Olimpiada olimp = null;

       try {
       	 Connection conn =  null;
   		 PreparedStatement ps = null;
   		 conn = new Conexao().getConnection();
   		 
           String selectQuery = "SELECT * FROM Olimpiada WHERE nome= ?";
           PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
           preparedStatement.setString(1, nome);
           ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet.next()) {
               String nomeOlimp = resultSet.getString("nomeCompleto");

               olimp = new Olimpiada(nomeOlimp);
           }
           resultSet.close();
           preparedStatement.close();
			conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return olimp;
   }
}
