package homework_4;

import ForSQL_Query.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class DatabaseQueryService {
    private final PreparedStatement selectMaxSalaryWorker;
    private final PreparedStatement selectMaxProjectCountClient;
    private final PreparedStatement selectPrintProjectPrices;
    private final PreparedStatement selectYoungestEldestWorkers;
    private final PreparedStatement selectLongestProject;
    public DatabaseQueryService() throws SQLException {
        Connection conn = Database.getInstance().getConnection();//"./sql/find/find_max_salary_worker.sql"
        selectMaxSalaryWorker = conn.prepareStatement(new SqlLink().toLink("./sql/find/find_max_salary_worker.sql"));
        selectMaxProjectCountClient = conn.prepareStatement(new SqlLink().toLink("./sql/find/find_max_projects_client.sql"));
        selectPrintProjectPrices = conn.prepareStatement(new SqlLink().toLink("./sql/find/print_project_prices.sql"));
        selectYoungestEldestWorkers = conn.prepareStatement(new SqlLink().toLink("./sql/find/find_youngest_eldest_workers.sql"));
        selectLongestProject = conn.prepareStatement(new SqlLink().toLink("./sql/find/find_longest_project.sql"));
    }

    public List<MaxSalaryWorker> find_max_salary_worker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        try (ResultSet rs = selectMaxSalaryWorker.executeQuery()){
                    if(rs.next()){
                        String name = rs.getString("name");
                        int salary = rs.getInt("salary");

                        maxSalaryWorkers.add(new MaxSalaryWorker(name,salary));
                        return maxSalaryWorkers;
                    } else {
                        System.out.println("Not found!");
                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                }

            return null;
    }

    public List<MaxProjectCountClient> find_max_projects_client(){//selectMaxProjectCountClient
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<MaxProjectCountClient>();

                try (ResultSet rs = selectMaxProjectCountClient.executeQuery()){
                    if(rs.next()){
                        String name = rs.getString("name");
                        int projectCount = rs.getInt("PROJECT_COUNT");

                        maxProjectCountClients.add(new MaxProjectCountClient(name,projectCount));
                        return maxProjectCountClients;
                    } else {
                        System.out.println("Not found!");
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }

        return null;
    }

    public List<PrintProjectPrices> print_project_prices(){//selectPrintProjectPrices
        List<PrintProjectPrices> printProjectPrices = new ArrayList<PrintProjectPrices>();

                try (ResultSet rs = selectPrintProjectPrices.executeQuery()){
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        int price = rs.getInt("price");

                        printProjectPrices.add(new PrintProjectPrices(id, price));
                    }

                    return printProjectPrices;
                } catch (SQLException ex){
                    ex.printStackTrace();
                }

        return null;
    }

    public List<YoungestEldestWorkers> find_youngest_eldest_workers(){//selectYoungestEldestWorkers
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<YoungestEldestWorkers>();

                try (ResultSet rs = selectYoungestEldestWorkers.executeQuery()){
                    while (rs.next()) {
                        String type = rs.getString("'TYPE'");
                        String name = rs.getString("NAME");
                        LocalDate birthday = rs.getDate("BIRTHDAY").toLocalDate();

                        youngestEldestWorkers.add(new YoungestEldestWorkers(type,name,birthday));
                    }

                    return youngestEldestWorkers;
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
        return null;
    }

    public List<LongestProject> find_longest_project(){//selectLongestProject
        List<LongestProject> longestProjects = new ArrayList<LongestProject>();

                try (ResultSet rs = selectLongestProject.executeQuery()){
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        int month_count = rs.getInt("month_count");

                        longestProjects.add(new LongestProject(id,month_count));
                    }

                    return longestProjects;
                } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
