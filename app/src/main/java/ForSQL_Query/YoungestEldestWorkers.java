package ForSQL_Query;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorkers(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String readYoungestEldestWorkers(){
        return "Type: "+type+" ,Name: "+name+" ,Birthday: "+birthday.toString();
    }
}
