package calendarEventPlanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventTest {
    private String name;
    private Date date;

    public EventTest(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getDateStr(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    @Override
    public String toString(){
        return "Event: " + name + "Date: " +getDateStr();
    }
}
