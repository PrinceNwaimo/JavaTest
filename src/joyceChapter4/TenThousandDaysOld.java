package joyceChapter4;

import java.time.LocalDate;

public class TenThousandDaysOld {
    public static void main(String[] args) {

        System.out.print("Enter your birthdate (yyyy-mm-dd): ");
        String birthdateStr = System.console().readLine();
        LocalDate birthdate = LocalDate.parse(birthdateStr);


        LocalDate tenThousandDaysOld = birthdate.plusDays(10000);


        System.out.println("You became (or will become) 10,000 days old on: " + tenThousandDaysOld);
    }
}
