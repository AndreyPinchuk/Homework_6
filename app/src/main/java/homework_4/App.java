package homework_4;

import ForSQL_Query.*;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {

        System.out.println("\n find_max_salary_worker.sql");
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().find_max_salary_worker();

        for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers) {
            System.out.println(maxSalaryWorker.readMaxSalaryWorker());
        }

        System.out.println("\n find_max_projects_client.sql");
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().find_max_projects_client();

        for (MaxProjectCountClient maxProjectCountClient : maxProjectCountClients) {
            System.out.println(maxProjectCountClient.readMaxProjectCountClient());
        }

        System.out.println("\n print_project_prices.sql");
        List<PrintProjectPrices> printProjectPrices = new DatabaseQueryService().print_project_prices();

        for (PrintProjectPrices printProjectPrice : printProjectPrices) {
            System.out.println(printProjectPrice.readPrintProjectPrices());
        }

        System.out.println("\n find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().find_youngest_eldest_workers();

        for (YoungestEldestWorkers youngestEldestWorker : youngestEldestWorkers) {
            System.out.println(youngestEldestWorker.readYoungestEldestWorkers());
        }

        System.out.println("\n find_longest_project.sql");
        List<LongestProject> longestProjects = new DatabaseQueryService().find_longest_project();

        for (LongestProject longestProject : longestProjects) {
            System.out.println(longestProject.readLongestProject());
        }
    }
}
