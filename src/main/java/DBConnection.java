import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dmitry on 23.02.2018.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String PASS = "root";
    private static final String LOGIN = "123qweasd";
    private Connection connection;
    public DBConnection(){
        try {
            connection = DriverManager.getConnection(URL,PASS,LOGIN);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){return connection;}

}
