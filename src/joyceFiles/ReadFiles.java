package joyceFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFiles {
        public static void main(String[] args){
            Path file = Paths.get("C:\\Java\\Chapter.13\\Grades.txt");
            InputStream input = null;
            try
            {
                input = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String s = null;
                s = reader.readLine();
                System.out.println(s);
                input.close();
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
        }
}
