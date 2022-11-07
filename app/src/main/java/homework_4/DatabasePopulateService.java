package homework_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args){
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement insertInitDB = conn.prepareStatement(new SqlLink().toLink("./sql/populate_db.sql"));
            insertInitDB.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
