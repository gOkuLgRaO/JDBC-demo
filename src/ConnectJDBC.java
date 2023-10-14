import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {

    public static void main(String[] args) throws Exception {
        try{
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
