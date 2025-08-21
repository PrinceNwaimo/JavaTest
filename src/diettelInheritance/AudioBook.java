package diettelInheritance;

public class AudioBook extends Book{
    private double sizeInMB;
    private double playLength;
    private String playbackArtist;

    public AudioBook(String title, int yearOfPublication, String author, double sizeInMB, double playLength, String playbackArtist) {
        super(title, yearOfPublication, author);
        this.sizeInMB = sizeInMB;
        this.playLength = playLength;
        this.playbackArtist = playbackArtist;
    }

    public double getSizeInMB() {
        return sizeInMB;
    }

    public void setSizeInMB(double sizeInMB) {
        this.sizeInMB = sizeInMB;
    }

    public double getPlayLength() {
        return playLength;
    }

    public void setPlayLength(double playLength) {
        this.playLength = playLength;
    }

    public String getPlaybackArtist() {
        return playbackArtist;
    }

    public void setPlaybackArtist(String playbackArtist) {
        this.playbackArtist = playbackArtist;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSize: " + sizeInMB + " MB\nPlay Length: " + playLength + " hours\nPlayback Artist: " + playbackArtist;
    }
}
