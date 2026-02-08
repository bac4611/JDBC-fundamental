package attribute;

import db.DBConnection;
import java.sql.*;

public class UserDAO {

    public void insert(String name, String email) throws SQLException {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        }
    }

    public void update(int id, String name, String email) throws SQLException {
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if(rows == 0){
                throw new SQLException("update fail" + id +"not found");
            }
        } catch(SQLException e){
            throw new SQLException("error when updating user", e);
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
