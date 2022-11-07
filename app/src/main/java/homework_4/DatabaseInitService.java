package homework_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args){
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement insertInitDB;
            insertInitDB = conn.prepareStatement(new SqlLink().toLink("./sql/init_db.sql"));
            insertInitDB.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
