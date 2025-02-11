package joyceChapter3;

public class MyCharacter {
    private String color;
    private int numEyes;
    private int numLives;

    public MyCharacter(String color, int numEyes, int numLives) {
        this.color = color;
        this.numEyes = numEyes;
        this.numLives = numLives;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumEyes() {
        return numEyes;
    }

    public void setNumEyes(int numEyes) {
        this.numEyes = numEyes;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", Number of Eyes: " + numEyes + ", Number of Lives: " + numLives;
    }
}
