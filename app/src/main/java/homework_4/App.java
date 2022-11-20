package homework_4;

import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {

        String connect = Database.getInstance().getAddressDB();

        Flyway flyway = Flyway
                .configure()
                .dataSource(connect, null, null)
                .load();

        flyway.migrate();

        List<Client> clients = new ClientService().listAll();
        for (Client client : clients) {
            System.out.println(client.toString());
        }

        System.out.println(new ClientService().create("Nic Blackwall"));
        System.out.println(new ClientService().getById(7));
        new ClientService().setName(7, "Daniel");
        System.out.println(new ClientService().getById(7));
        new ClientService().deleteById(7);

        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }
}
