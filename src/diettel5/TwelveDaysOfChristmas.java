package diettel5;

public class TwelveDaysOfChristmas {
    public static void main(String[] args) {
        String[] days = {"first", "second", "third", "fourth", "fifth",
                "sixth", "seventh", "eighth", "ninth",
                "tenth", "eleventh", "twelfth"};

        String[] gifts = {"A Partridge in a Pear Tree",
                "Two Turtle Doves",
                "Three French Hens",
                "Four Calling Birds",
                "Five Golden Rings",
                "Six Geese a-Laying",
                "Seven Swans a-Swimming",
                "Eight Maids a-Milking",
                "Nine Ladies Dancing",
                "Ten Lords a-Leaping",
                "Eleven Pipers Piping",
                "Twelve Drummers Drumming"};

        for (int i = 0; i < days.length; i++) {
            System.out.println("On the " + days[i] + " day of Christmas, my true love gave to me");

            switch (i) {
                case 11: System.out.println(gifts[11]); // Twelve Drummers Drumming
                case 10: System.out.println(gifts[10]); // Eleven Pipers Piping
                case 9: System.out.println(gifts[9]); // Ten Lords a-Leaping
                case 8: System.out.println(gifts[8]); // Nine Ladies Dancing
                case 7: System.out.println(gifts[7]); // Eight Maids a-Milking
                case 6: System.out.println(gifts[6]); // Seven Swans a-Swimming
                case 5: System.out.println(gifts[5]); // Six Geese a-Laying
                case 4: System.out.println(gifts[4]); // Five Golden Rings
                case 3: System.out.println(gifts[3]); // Four Calling Birds
                case 2: System.out.println(gifts[2]); // Three French Hens
                case 1: System.out.println(gifts[1]); // Two Turtle Doves
                case 0: System.out.println(gifts[0]); // A Partridge in a Pear Tree
            }

            if (i > 0) {
                System.out.println();
            }
        }
    }

}
