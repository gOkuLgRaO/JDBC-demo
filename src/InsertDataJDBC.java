import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataJDBC {
    // for prepared statements
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

            String queue = "insert into table1(tName, tCity) values(?,?)";

            // get the PreparedStatement object
            PreparedStatement pstmt = connection.prepareStatement(queue);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name = br.readLine();
            System.out.println("Enter city ");
            String city = br.readLine();

            // set the values to query
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();

            System.out.println("Inserted values......");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * "select * from table1;" - shows all rows of the table
 */