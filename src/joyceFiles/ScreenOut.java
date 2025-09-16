package joyceFiles;

import java.io.OutputStream;

public class ScreenOut {
    public static void main(String[] args)
    {
        String s = "ABCDEF";
        byte[] data = s.getBytes();
        OutputStream output = null;
        try
        {
            output = System.out;
            output.write(data);
            output.flush();
            output.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
    }
}
