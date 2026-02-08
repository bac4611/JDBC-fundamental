import java.sql.Connection;
import java.sql.DriverManager;

import attribute.ProductDAO;
import attribute.UserDAO;
import db.DBInit;
import model.Usermodel;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDAO um = new UserDAO();

        um.insert("Nguyen Van A", "a@gmail.com");
        um.update(1, "Updated", "updated@gmail.com");
        um.delete(2);
        

        ProductDAO pd = new ProductDAO();
        pd.insert(1, "my hao hao", 3500, 160, "my cua vn");
        pd.insert(2, "my omi", 4000, 1239, "my cua vn");
        pd.insert(3, "my omachi", 3600, 104, "my cua vn");
        pd.insert(4, "my cay", 5500, 123, "my cua han quoc");
        
        DBInit.init();  //Use for create table
       
    }
}
