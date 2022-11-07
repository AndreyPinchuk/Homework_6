package homework_4;;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database{
    private static final Database INSTANCE = new Database();

    private Connection connection;
    private Database(){
        try {
            String get = "jdbc:h2:./test2";
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

    public int executeUpdate(String sql){  //для команд зміни даних
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