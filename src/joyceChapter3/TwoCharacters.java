package joyceChapter3;

public class TwoCharacters {
    public static void displayCharacter(MyCharacter character) {
        System.out.println(character.toString());
    }

    public static void main(String[] args) {
        MyCharacter character1 = new MyCharacter("Red", 2, 5);
        MyCharacter character2 = new MyCharacter("Blue", 3, 3);

        System.out.println("Character 1:");
        displayCharacter(character1);

        System.out.println("\nCharacter 2:");
        displayCharacter(character2);
    }
}
