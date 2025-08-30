package joyceInheritance;

public class Poem {
    private String title;
    private int lines;

    public Poem(String title, int lines) {
        this.title = title;
        this.lines = lines;
    }

    public String getTitle() {
        return title;
    }

    public int getLines() {
        return lines;
    }
}
