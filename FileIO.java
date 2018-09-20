
/**
 * Write a description of class FileIO here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.*;
public class FileIO
{
    // instance variables - replace the example below with your own
    private String fileName;

    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
        // initialise instance variables
        fileName = "gamesettings.txt";
    }

    /**
     * Get information from file gamesettings.txt
     */ 
    public String[] readingFromFile()
    {   
        try
        {
            FileReader inputFile = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(inputFile);
                String name = parser.nextLine();
                String[] info = name.split(",");
                return info;
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
            {
                System.out.println(fileName + " not found");
                return null;
            }
        catch(IOException exception)
            {
                System.out.println("Unexpected I/O exception occurs");
                return null;
            } 
    }
}
