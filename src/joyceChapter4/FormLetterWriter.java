package joyceChapter4;

public class FormLetterWriter {

    public void displaySalutation(String name){
        System.out.println("Dear Mr. or Ms. "+ name +"\n Thank you for your recent order.");
    }
    public void displaySalutation(String firstName, String lastName){
        System.out.println("Dear "+ firstName+ " "+ lastName + "\n Thank you for your recent order.");
    }
}
