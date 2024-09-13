package diettel4;

public class TabularOutput {
    public static void main(String[] args) {
        // Print the header
        System.out.println("Item\tValue");
        System.out.println("-----\t-----");
        System.out.println("1\t239.99");
        System.out.println("2\t129.75");
        System.out.println("3\t99.95");
        System.out.println("4\t350.89");
        System.out.println();

        // Print the second table
        System.out.println("N\tN2\tN3\tN4");
        System.out.println("--\t---\t---\t---");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + "\t");
            System.out.print(i * i + "\t");
            System.out.print(i * i * i + "\t");
            System.out.println(i * i * i * i);
            i++;
        }
    }

}
