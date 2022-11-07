package ForSQL_Query;

public class LongestProject {
    private long id;
    private int month_count;

    public LongestProject(long id, int month_count) {
        this.id = id;
        this.month_count = month_count;
    }

    public String readLongestProject(){
        return "ID: "+id+" ,Month_count: "+month_count;
    }
}
