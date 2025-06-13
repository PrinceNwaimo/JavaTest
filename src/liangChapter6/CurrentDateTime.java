package liangChapter6;

import java.util.Date;

public class CurrentDateTime {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        System.out.println(date.toString());
    }

}
