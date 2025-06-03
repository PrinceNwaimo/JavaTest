package characterAndStrings;

import java.util.Scanner;

public class TryToCompareStrings {
    public static void main(String[] args) {
        String aName = "Carmen";
        String anotherName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        anotherName = input.nextLine();
        if(aName == anotherName){
            System.out.println(aName + " equals " + anotherName);
        }
        else{
            System.out.println(aName + " does not equal " + anotherName);
        }
    }
}
