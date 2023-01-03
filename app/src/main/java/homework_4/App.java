package homework_4;

import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {


        Database.flywayStart();

        System.out.println("\n повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client\n");
        List<Client> clients = new ClientService().listAll();
        for (Client client : clients) {
            System.out.println(client.toString());
        }


        System.out.println("\n\n додає нового клієнта з іменем Nic Blackwall. Повертає ідентифікатор щойно створеного клієнта\n");
        System.out.println(new ClientService().create("Nic Blackwall"));

        System.out.println("\n\n повертає назву клієнта з ідентифікатором id = 5\n");
        System.out.println(new ClientService().getById(5));

        System.out.println("\n\n встановлює нове ім'я name для клієнта з ідентифікатором id = 6\n");
        new ClientService().setName(6, "Daniel");
        System.out.println(new ClientService().getById(6));

        System.out.println("\n\n видаляє клієнта з ідентифікатором id = 7\n");
        new ClientService().deleteById(7);

        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }
}
