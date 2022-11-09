package homework_4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    private final PreparedStatement insertWorker;
    private final PreparedStatement insertClient;
    private final PreparedStatement insertProject;
    private final PreparedStatement insertProjectWorker;

    private DatabasePopulateService() throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        insertWorker = conn.prepareStatement(
                "INSERT INTO WORKER (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)");
        insertClient = conn.prepareStatement(
                "INSERT INTO CLIENT (NAME) VALUES (?)");
        insertProject = conn.prepareStatement(
                "INSERT INTO PROJECT (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)");
        insertProjectWorker = conn.prepareStatement(
                "INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID ) VALUES (?,?)");
    }

    public void createdWorker(List<Worker> workers) {
        try {
            for (Worker worker : workers) {
                insertWorker.setString(1, worker.getName());
                insertWorker.setDate(2, Date.valueOf(worker.getBirthday()));
                insertWorker.setString(3, worker.getLevel());
                insertWorker.setInt(4, worker.getSalary());

                insertWorker.addBatch();
            }
            insertWorker.executeBatch();

        } catch (SQLException ex){
            System.out.println("createdWorker -> SQLException");
            ex.printStackTrace();
        }

    }
    public void createdClients(String[] clients) {
        try {
            for (String client : clients) {
                insertClient.setString(1, client);

                insertClient.addBatch();
            }
            insertClient.executeBatch();

        } catch (SQLException ex){
            System.out.println(" -> SQLException");
            ex.printStackTrace();
        }
    }
    public void project(List<Project> projects) {
        try {
            for (Project project : projects) {
                insertProject.setLong(1, project.getClientID());
                insertProject.setDate(2, Date.valueOf(project.getStartProject()));
                insertProject.setDate(3, Date.valueOf(project.getFinishProject()));

                insertProject.addBatch();
            }
            insertProject.executeBatch();

        } catch (SQLException ex){
            System.out.println(" -> SQLException");
            ex.printStackTrace();
        }
    }
    public void projectWorcers(long[][] idTOid) {
        try {
            for (int i = 0; i < idTOid.length; i++) {

                insertProjectWorker.setLong(1, idTOid[i][0]);
                insertProjectWorker.setLong(2, idTOid[i][1]);

                insertProjectWorker.addBatch();
            }
            insertProjectWorker.executeBatch();

        } catch (SQLException ex){
            System.out.println(" -> SQLException");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){

        List<Worker> workers = new ArrayList<>();
            workers.add(new Worker("Mark Jakob",
                    LocalDate.of(1995,10, 3), "Junior", 800));
            workers.add(new Worker("Jim Ford",
                    LocalDate.of(2000,8,15),"Middle", 1200));
            workers.add(new Worker("Rosy Bafoun",
                    LocalDate.of(1994,1,6),"Senior", 1900));
            workers.add(new Worker("Bill Trast",
                    LocalDate.of(1988,3,11),"Trainee", 5900));
            workers.add(new Worker("Karl Magic",
                    LocalDate.of(2005,10,1),"Middle", 2300));
            workers.add(new Worker("Naomi Salar",
                    LocalDate.of(2007,2,14),"Junior", 1000));
            workers.add(new Worker("Natan Browen",
                    LocalDate.of(1999,12,9),"Senior", 2800));
            workers.add(new Worker("Ruf Rimes",
                    LocalDate.of(2003,4,4),"Senior", 3000));
            workers.add(new Worker("Richi Foster",
                    LocalDate.of(1995,3,16),"Middle", 1500));
            workers.add(new Worker("Cristin Malta",
                    LocalDate.of(1997,5,29),"Trainee", 5000));

            String[] clients = {
                    "Judi Karum",
                    "Michael Turner",
                    "Toky Mikaoto",
                    "Nike Demios",
                    "Rih Magdaun",
                    "Natali Forg"
            };

        List<Project> projects = new ArrayList<>();
            projects.add(new Project(
                    1,
                    LocalDate.of(2014,9,12),
                    LocalDate.of(2022,2,10)));
        projects.add(new Project(
                1,
                LocalDate.of(2017,12,20),
                LocalDate.of(2021,10,23)));
        projects.add(new Project(
                5,
                LocalDate.of(2018,8,12),
                LocalDate.of(2020,12,12)));
        projects.add(new Project(
                6,
                LocalDate.of(2018,9,1),
                LocalDate.of(2019,7,19)));
        projects.add(new Project(
                2,
                LocalDate.of(2018,10,1),
                LocalDate.of(2022,1,29)));
        projects.add(new Project(
                3,
                LocalDate.of(2018,12,11),
                LocalDate.of(2019,2,20)));
        projects.add(new Project(
                5,
                LocalDate.of(2019,1,19),
                LocalDate.of(2021,8,22)));
        projects.add(new Project(
                1,
                LocalDate.of(2020,6,6),
                LocalDate.of(2021,10,27)));
        projects.add(new Project(
                4,
                LocalDate.of(2021,4,15),
                LocalDate.of(2022,10,4)));
        projects.add(new Project(
                2,
                LocalDate.of(2021,9,25),
                LocalDate.of(2022,7,19)));

        long[][] projectWorker = {
                {1,10}, {1,5}, {1,3}, {1,7},
                {2,2}, {2,4}, {2,6},
                {3,5}, {3,4}, {3,8},
                {4,3}, {4,10},
                {5,3}, {5,9}, {5,5},
                {6,7}, {6,8},
                {7,4}, {7,6}, {7,9},
                {8,4}, {8,8},
                {9,4},
                {10,1}, {10,8}
            };

        try {
            new DatabasePopulateService().createdWorker(workers);
            new DatabasePopulateService().createdClients(clients);
            new DatabasePopulateService().project(projects);
            new DatabasePopulateService().projectWorcers(projectWorker);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }



}
class Worker{
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

    public Worker(String name, LocalDate birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
class Project{
    private long clientID;
    private LocalDate startProject;
    private LocalDate finishProject;

    public Project(long clientID, LocalDate startProject, LocalDate finishProject) {
        this.clientID = clientID;
        this.startProject = startProject;
        this.finishProject = finishProject;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public LocalDate getStartProject() {
        return startProject;
    }

    public void setStartProject(LocalDate startProject) {
        this.startProject = startProject;
    }

    public LocalDate getFinishProject() {
        return finishProject;
    }

    public void setFinishProject(LocalDate finishProject) {
        this.finishProject = finishProject;
    }
}
