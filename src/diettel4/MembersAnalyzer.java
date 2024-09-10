package diettel4;

import java.util.Scanner;

public class MembersAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int male = 0;
        int female = 0;
        int counter =1;

        while(counter <= 5){
            System.out.print("Enter Sex (Male = 1, Female = 2): ");
            int sex = input.nextInt();

            if( sex == 1){
                male = male + 1;
            }
            else {
                female = female + 1;
            }
            counter = counter + 1;
        }
        System.out.printf("Male: %d%nFemale: %d%n", male, female);
        if(male > 2){
            System.out.println("Male dominated");
        }
        else{
            System.out.println("Female dominated");
        }
    }
}
