package stringsMethods;

public class Example1 {
    public static void main(String[] args) {
        String A = "b";
        String B = "b";

        sign(A,B);
        equality(A,B);
    }
    private static void sign(String number, String number2){
        if (number == number2){
            System.out.println("String 1 and String 2 are equal");
        }
        else {
            System.out.println("String 1 and String 2 are not equal");
        }
    }
    private static void equality(String number1, String number2){
        if(number1.equals(number2)){
            System.out.println("String 1 and String 2 are equal");
        }
        else{
            System.out.println("String 1 and String 2 are not equal");
        }
    }
}
