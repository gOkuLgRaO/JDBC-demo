import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDataJDBC {
    public static void main(String[] args) {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating a connection
            String url="jdbc:mysql://localhost:3306/gokuljdbcdemo";
            String username="root";
            String password="@GOKULrao10";

            Connection connection=DriverManager.getConnection(url, username, password);
            if(connection.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection created......");
            }

            String query="select * from table1";
            Statement stmt=connection.createStatement();
            ResultSet set=stmt.executeQuery(query);
            while(set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(id+":"+name+":"+city);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
