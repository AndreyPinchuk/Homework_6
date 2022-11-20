package homework_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final PreparedStatement insertClient;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement getByIdSt;
    private PreparedStatement updateClient;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement selectClient;


    public ClientService() throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        insertClient = conn.prepareStatement(
                "INSERT INTO CLIENT (NAME) VALUES (?)");
        selectMaxIdSt = conn.prepareStatement(
                "SELECT max(id) AS maxId FROM client"
        );
        getByIdSt = conn.prepareStatement(
                "SELECT name FROM client WHERE id = ?"
        );
        updateClient = conn.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?"
        );
        deleteByIdSt = conn.prepareStatement(
                "DELETE FROM client WHERE id = ?"
        );
        selectClient = conn.prepareStatement(
                "SELECT id, name FROM client"
        );
    }

    //�������� �� ������� ��'�
    public boolean rightName(String name) {
        if(name.length()<2 || name.length()>100){
            try {
                throw new Exception("Name is not nice");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Name is not nice");
            return false;
        } else {
            return true;
        }
    }
    //���� ������ �볺��� � ������ name. ������� ������������� ����� ���������� �볺���
    public long create(String name) throws SQLException {
        if(rightName(name)){
            insertClient.setString(1, name);
            insertClient.executeUpdate();
        }
        long id;
        try(ResultSet rs = selectMaxIdSt.executeQuery()) {
            rs.next();
            id = rs.getLong("maxId");
        }
        return id;
    }

    //������� ����� �볺��� � ��������������� id
    public String getById(long id) throws SQLException {
        getByIdSt.setLong(1, id);

        try (ResultSet rs = getByIdSt.executeQuery()){
            if (!rs.next()) {
                return null;
            }

            return rs.getString("name");
        }
    }

    //���������� ���� ��'� name ��� �볺��� � ��������������� id
    public void setName(long id, String name) throws SQLException {
        if(rightName(name)){
            updateClient.setString(1, name);
            updateClient.setLong(2, id);

            updateClient.executeUpdate();

        }
    }

    //������� �볺��� � ��������������� id
    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1, id);
        deleteByIdSt.executeUpdate();
    }

    //������� ��� �볺��� � �� � ������ �������� ��'���� ���� Client (��� ���� ������ ���, � ����� �� ���� 2 ���� - id �� name)
    public List<Client> listAll(){
        List<Client> clients = new ArrayList<>();

        try (ResultSet rs = selectClient.executeQuery()){
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");

                clients.add(new Client(id, name));
            }
            return clients;
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }
}
