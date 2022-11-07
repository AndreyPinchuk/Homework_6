package homework_4;

public class DatabaseInitService {
    public static void main(String[] args){
        Database.getInstance().executeUpdate(new SqlLink().toLink("./sql/init_db.sql"));
    }
}
