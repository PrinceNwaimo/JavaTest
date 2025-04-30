package joyceUsingLoops;

public class CountBy5 {
    public static void main(String[] args) {
        final int LIMIT = 500;
        int number;

        for (number = 5; number <= LIMIT; number+=5){
            System.out.print(number + " ");
                if(number % 50 == 0)
                    System.out.println();
            }
        }
    }

