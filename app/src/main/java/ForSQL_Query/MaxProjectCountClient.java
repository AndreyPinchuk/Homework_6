package ForSQL_Query;

public class  MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }
    public String readMaxProjectCountClient(){
        return "Name: "+name+" ,ProjectCount: "+projectCount;
    }
}