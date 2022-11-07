package homework_4;

public class DatabasePopulateService {
    public static void main(String[] args){
        Database.getInstance().executeUpdate(new SqlLink().toLink("./sql/populate_db.sql"));
    }
}
