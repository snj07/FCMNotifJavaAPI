package dbase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbOperation {
	private Connection conn;
	private static final String COL_EMAIL_ID = "EMAIL_ID";
	private static final String COL_TOKEN = "TOKEN";
	private static final String TABLE_DEVICES = "devices";

	public DbOperation() {
		conn = DbConnection.getConnection();
	}

	public int registerDevice(String email, String token) {
		if (!isEmailExists(email)) {
			String sql = "insert into " + TABLE_DEVICES + "(" + COL_EMAIL_ID + " , " + COL_TOKEN + ") values (?,?); ";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, token);
				int i = ps.executeUpdate();
				if (i > 0)
					return 1; // success

			} catch (SQLException e) {
				e.printStackTrace();

			}
			return 3;// failure
		}
		return 2; // already exists
	}

	public boolean isEmailExists(String email) {
		String sql = "select * from " + TABLE_DEVICES + " where " + COL_EMAIL_ID + " = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	public List<String> getAllTokens() {
		String sql = "select * from " + TABLE_DEVICES + " ;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			List<String> tokens = new ArrayList<>();
			while (resultSet.next()) {
				tokens.add(resultSet.getString(COL_TOKEN));
			}
			return tokens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTokenByEmail(String email) {
		String sql = "select * from " + TABLE_DEVICES + " where " + COL_EMAIL_ID + " = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString(COL_TOKEN);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
