import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImageJDBC {
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

            String query = "insert into images(pic) values(?)";

            PreparedStatement pstmt = connection.prepareStatement(query);

            FileInputStream file = new FileInputStream("D:\\pictures\\Pictures\\bcs.jpg");

            pstmt.setBinaryStream(1, file, file.available());
            pstmt.executeUpdate();
            System.out.println("Done......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
