package liangMultiArrays;

import java.util.Scanner;

public class GuessTheCapitals {
    public static void main(String[] args) {
        String[][] statesAndCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "St. Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;

        for (String[] state : statesAndCapitals) {
            System.out.print("What is the capital of " + state[0] + "? ");
            String answer = scanner.nextLine().trim().toLowerCase();
            String correctAnswer = state[1].toLowerCase();

            if (answer.equals(correctAnswer)) {
                String.format("The answer is correct.%n");
                correctCount++;
            } else {
                String.format("The answer is wrong.%n");
                System.out.println("The correct answer is " + state[1]);
            }
        }

        System.out.println("You got " + correctCount + " out of " + statesAndCapitals.length + " questions correct.");
    }

}
