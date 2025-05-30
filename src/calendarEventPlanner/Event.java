package calendarEventPlanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
        private String name;
        private Date date;

        public Event(String name, Date date) {
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

        public String getDateStr() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date);
        }

        @Override
        public String toString() {
//        return name + " - " + getDateStr();
            return "Event: " + name + "Date: " +getDateStr();
        }
    }

