package bl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:8088/test1";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "1987";

    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return connection;
    };

}