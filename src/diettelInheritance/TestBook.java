package diettelInheritance;

public class TestBook {
    public static void main(String[] args) {
        Book book = new Book("Book Title", 2020, "Author Name");
        System.out.println("Book:");
        System.out.println(book.toString());

        PrintBook printBook = new PrintBook("Print Book Title", 2020, "Author Name", "Publisher Name", "1234567890");
        System.out.println("\nPrint Book:");
        System.out.println(printBook.toString());

        AudioBook audioBook = new AudioBook("Audio Book Title", 2020, "Author Name", 100.0, 5.0, "Playback Artist Name");
        System.out.println("\nAudio Book:");
        System.out.println(audioBook.toString());
    }
}
