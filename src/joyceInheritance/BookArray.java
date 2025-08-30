package joyceInheritance;

public class BookArray {
    public static void main(String[] args) {
        Book[] books = new Book[10];

        books[0] = new Fiction("The Catcher in the Rye");
        books[1] = new NonFiction("The Origin of Species");
        books[2] = new Fiction("To Kill a Mockingbird");
        books[3] = new NonFiction("A Brief History of Time");
        books[4] = new Fiction("The Lord of the Rings");
        books[5] = new NonFiction("The Selfish Gene");
        books[6] = new Fiction("Pride and Prejudice");
        books[7] = new NonFiction("The Interpretation of Dreams");
        books[8] = new Fiction("The Hunger Games");
        books[9] = new NonFiction("Sapiens: A Brief History of Humankind");

        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: $" + book.getPrice());
            System.out.println();
        }
    }
}
