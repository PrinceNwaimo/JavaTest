package liangChapter6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime2 {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(date));
    }

}
