import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDataJDBC {
    public static void main(String[] args) {
        try {
            // load the driver
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

            String queue = "update table1 set tName=?, tCity=? where tId=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name");
            String name = br.readLine();
            System.out.println("Enter new city name");
            String city = br.readLine();
            System.out.println("Enter the student ID");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = connection.prepareStatement(queue);
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Done.......");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
