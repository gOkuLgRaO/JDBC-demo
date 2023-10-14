import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AlterImageTableJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating a connection
            String url = "jdbc:mysql://localhost:3306/gokuljdbcdemo";
            String username = "root";
            String password = "@GOKULrao10";

            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created......");
            }

            // create a query
            String query = "alter table images modify pic longblob";

            // create statement

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("table altered...");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

