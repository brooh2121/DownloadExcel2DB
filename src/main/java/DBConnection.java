import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Dmitry on 23.02.2018.
 */
public class DBConnection {
    //private static final String URL = "jdbc:mysql://localhost:3306/test";
    //private static final String PASS = "root";
    //private static final String LOGIN = "123qweasd";
    Properties prop = new Properties();
    FileInputStream fs;
    private Connection connection;
    public DBConnection(){
        try {
            fs = new FileInputStream("application.properties");
            prop.load(fs);
            Class.forName(prop.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("LOGIN"),prop.getProperty("PASS"));
        }catch (SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){return connection;}

}
