package liangInheritance;

import java.util.ArrayList;
import java.util.Date;

public class TestLoanCircle {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Loan(2.5, 5, 10000));
        list.add(new Date());
        list.add("Hello, World!");
        list.add(new Circle(5.0));

        for (Object obj : list) {
            System.out.println(obj.toString());
            System.out.println("--------------------");
        }
    }
}
