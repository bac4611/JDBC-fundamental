package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

    public static void init() {

        String createProductTable = """
            CREATE TABLE IF NOT EXISTS products (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(150),
                price DOUBLE,
                quantity INT,
                description TEXT
            )
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(createProductTable);
            System.out.println("products table ready");

        } catch (Exception e) {
            System.out.println("Can not create table");
            System.out.println("Reason" + e.getMessage());
        }
    }
}
