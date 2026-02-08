package attribute;

import db.DBConnection;
import model.Productmodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // CREATE
    public void insert(int id, String name, double price, int quantity, String description) {
        String sql = "INSERT INTO products(id, name, price, quantity, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, description);

            ps.executeUpdate();
            System.out.println("Insert product success");

        } catch (SQLException e) {
            System.out.println("Insert product failed");
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int id, String name, double price, int quantity, String description) {
        String sql = "UPDATE products SET name=?, price=?, quantity=?, description=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, description);
            ps.setInt(5, id);

            ps.executeUpdate();
            System.out.println("Update product success");

        } catch (SQLException e) {
            System.out.println("Update product failed");
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Delete product success");

        } catch (SQLException e) {
            System.out.println("Delete product failed");
            e.printStackTrace();
        }
    }

    // READ ONE
    public Productmodel findById(int id) {
        String sql = "SELECT * FROM products WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Productmodel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Find product failed");
            e.printStackTrace();
        }
        return null;
    }

    // READ ALL
    public List<Productmodel> findAll() {
        String sql = "SELECT * FROM products";
        List<Productmodel> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Productmodel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Get product list failed");
            e.printStackTrace();
        }
        return list;
    }
}
