package diettel4;

import java.util.Scanner;

public class Membership {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int male = 0;
        int female = 0;
        int counter = 1;

        System.out.print("Enter the sex (Male = 1, Female = 2), press -1 to exit: ");
        int sex = input.nextInt();

        while(sex != -1){
            if (sex == 1){
                male +=1;
            }
            else{
                female += 1;
            }
            System.out.print("Enter the sex (Male = 1, Female = 2), press -1 to exit: ");
            sex = input.nextInt();
        }
        counter+=1;
        System.out.printf("Male: %d%nFemale: %d%n",male,female);

        if(male > female){
            System.out.println("Male dominated");
        }
        else{
            System.out.println("Female dominated");
        }
    }
}
