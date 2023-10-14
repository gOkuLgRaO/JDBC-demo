import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InsertImageDynamicallyJDBC {
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
            JFileChooser jfile = new JFileChooser();
            jfile.showOpenDialog(null);
            File file = jfile.getSelectedFile();
            FileInputStream fileinput = new FileInputStream(file);
            pstmt.setBinaryStream(1, fileinput, fileinput.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "success");
            System.out.println("Inserted large Image....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
