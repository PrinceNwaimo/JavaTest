package liangExceptionHandling;

import java.io.FileNotFoundException;

public class WriteDataWithAutoClose {
    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("scores.txt");
        if(file.exists()){
            System.out.println("File already exists");
            System.exit(0);
        }
        try(java.io.PrintWriter output = new java.io.PrintWriter(file);)
        {
            output.print("Prince Nwaimo");
            output.println(90);
            output.print("Eric K Jones");
            output.println(85);

        }
    }
}
