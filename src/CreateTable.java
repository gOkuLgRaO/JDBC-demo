import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
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
            String query = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";

            // create a statement:
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("table created in database...");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
 * "\s" - shows all info about mysql db
 * "show databases;" - shows all the databases
 * "create database gokuljdbcdemo;" - create a database of required name
 * "use gokuljdbcdemo;" - control shifts to this database
 * "show tables;" - shows all tables of database
 * "desc table1;" - description of table1 will be shown
 */
