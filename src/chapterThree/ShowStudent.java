package chapterThree;

import java.util.Scanner;

public class ShowStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student newComer = new Student();
        System.out.println("Enter new student name:  ");
        String newStudent = input.nextLine();
        newComer.setName(newStudent);
        System.out.println("Enter student ID:");
        int ID = input.nextInt();
        newComer.setID(ID);
        System.out.println("Enter number of credit hours to accomplish: ");
        int hours = input.nextInt();
        newComer.setCreditHours(hours);
        System.out.println("Enter former GPA: ");
        double GP = input.nextDouble();
        newComer.setGP(GP);
        System.out.println("New Student details :"+ newComer.getName()+" \n with ID"+ newComer.getID()+"\n"+ newComer.getGP()+"\n has "+newComer.ComputeGPA());

    }

}
