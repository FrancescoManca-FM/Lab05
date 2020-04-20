package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorretto(String anagramma) {
		String sql = "SELECT * FROM parola WHERE nome = ?";
		Boolean giusta = false;
		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, anagramma);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			giusta=true;
		}
		conn.close();
		return giusta;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
