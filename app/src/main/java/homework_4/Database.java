package homework_4;;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database{
    private static final Database INSTANCE = new Database();
    private static final String get = "jdbc:h2:./test";

    private Connection connection;
    private Database(){
        try {
            connection = DriverManager.getConnection(get);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
    public String getAddressDB(){
        return get;
    }

    public static void flywayStart(){
        Flyway flyway = Flyway
                .configure()
                .dataSource(getInstance().getAddressDB(), null, null)
                .load();

        flyway.migrate();
    }

    public int executeUpdate(String sql){
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}