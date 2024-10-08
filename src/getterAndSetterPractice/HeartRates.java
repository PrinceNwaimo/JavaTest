package getterAndSetterPractice;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HeartRates {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    private int age;

    private int HR;

    public HeartRates(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int AgeCalculator(String dob){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dob,formatter);
        LocalDate currentDate = LocalDate.now();
        age = Period.between(date,currentDate).getYears();
        return age;
    }
    public int MaxHeartRate(){
         HR = 220 - age;
        return HR;
    }
    public int TargetHR(double range){
        int target = (int) (range/100 * HR);
        return target;
    }


}
