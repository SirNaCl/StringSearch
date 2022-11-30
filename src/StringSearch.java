import java.io.*;
import java.util.Scanner;

public class StringSearch {
    public static String findLines(String pattern, String filename){
        try
        {
            FileInputStream fs = new FileInputStream(filename);
            Scanner scanner = new Scanner(fs);
            StringBuilder out = new StringBuilder();
            String line;
            int i = 1;

            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                if(line.contains(pattern))
                    out.append('\n').append(i).append(": ").append(line).append("\n============");
                i++;
            }
            scanner.close();

            return out.toString();

        } catch (FileNotFoundException e) {
            return "File not found";
        }
    }

    public static void main(String[] args) {
        try{
            System.out.println("Lines with pattern " + args[0] + " in file " + args[1] + ":");
            System.out.println(findLines(args[0], args[1]));
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Incorrect number of arguments: <pattern> <filename>");
        }
    }
}