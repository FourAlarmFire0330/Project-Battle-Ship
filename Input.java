
/**
 * Write a description of class Input here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Input
{
    public Input()
    {}
    
    public static void readFromKeyBoard()
    {
        Scanner console = new Scanner(System.in);
        console.nextLine();
    }    
    
    public static String readStringFromKeyBoard()
    {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }
    
    public static int readIntFromKeyBoard()
    {
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }    
}
