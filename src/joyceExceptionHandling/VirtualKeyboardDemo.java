package joyceExceptionHandling;

import java.io.IOException;
import java.util.Scanner;

public class VirtualKeyboardDemo {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            Process proc = Runtime.getRuntime().exec
                    ("cmd /c C:\\Windows\\System32\\osk.exe");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        String name;
        System.out.print("Enter name >> ");
        name = input.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
