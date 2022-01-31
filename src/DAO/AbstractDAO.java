package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
	protected Connection conn;
	
	public AbstractDAO() {
		try {


			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproyectodb?serverTimezone=UTC", "UsuarioPokedex",
					"P@ssword");


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}