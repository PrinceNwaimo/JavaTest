package joyceInheritance;

public class UseBook {
    public static void main(String[] args) {
        Book fictionBook = new Fiction("The Great Gatsby");
        Book nonFictionBook = new NonFiction("The History of the World");

        System.out.println("Fiction Book:");
        System.out.println("Title: " + fictionBook.getTitle());
        System.out.println("Price: $" + fictionBook.getPrice());

        System.out.println("\nNon-Fiction Book:");
        System.out.println("Title: " + nonFictionBook.getTitle());
        System.out.println("Price: $" + nonFictionBook.getPrice());
    }
}
