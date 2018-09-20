
/**
 * Write a description of class Game here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
import java.io.*;
public class Game
{    
    /**
    * Fields
    */
    private ShipList playerShips;
    private ShipList computerShips;
    
    /**
     * Default Constructor
     */
    public Game()
    {
        playerShips = new ShipList();
        computerShips = new ShipList();
    }
    
    /**
     * accessor and mutator method
     */
    public void setPlayerShips(ShipList playerShips)
    {
        this.playerShips = playerShips;
    }
    public ShipList getPlayerShips()
    {
        return playerShips;
    }
    
    public void setComputerShips(ShipList computerShips)
    {
        this.computerShips = computerShips;
    }
    public ShipList getComputerShips()
    {
        return computerShips;
    }
    
    //  Reading files and Showing the welcome page
    public void welcomeToGame()
    {
        FileIO readFile = new FileIO();
        String[] info = new String[4];        
        info = readFile.readingFromFile();
        
        if (info == null)
        {
            System.out.println("Something Wrong with your game settings file, pls check");
            System.exit(0);
        }
        else 
        {
            System.out.println("+================================================================+");
            System.out.println("|                                                                |");
            System.out.println("|       Welcome to the BattleShip Game -- With a Twist!!         |");
            System.out.println("|                                                                |"); 
            System.out.println("+================================================================+");
            System.out.println("The game will use the grid size defined in the settings file.");
            System.out.println("Playing grid size set as (" + info[0] + "*" + info[0] + ")");
            System.out.println("Maximum number of ships allowed as " + info[3]);
            System.out.println("Mutiple hits allowed per ships set as " + info[1]);
            if (info[2] == "true")
                System.out.println("Computer Ships Visible : ON");
            else
                System.out.println("Computer Ships Visible : OFF");            
            System.out.println("Press any Key to continue...");
            Input.readFromKeyBoard();
        }
    }
    
    //  method for loading the settings
    public void loadingSettings()
    {
        FileIO readFile = new FileIO();
        String[] info = new String[4];        
        info = readFile.readingFromFile();        
        String ShipName = "";
        int[] xRepeatPos = new int[Integer.parseInt(info[0])];
        int[] yRepeatPos = new int[Integer.parseInt(info[0])];
        int xPos = 0;
        int yPos = 0;
        boolean isNumeric = false;
        
        System.out.println("Loading player settings:");
        for (int i = 1; i <= Integer.parseInt(info[3]); i++)
        {
            System.out.println("Please enter the details for the " + i + " ship:");
            System.out.println("ShipName:");
            do {
                ShipName = Input.readStringFromKeyBoard();
            } while (!Validation.checkShipName(ShipName));
            do {
                System.out.println("Ship x Position (0 - " + (Integer.parseInt(info[0])) + "): ");
                do {
                    try {
                        xPos = Input.readIntFromKeyBoard();
                        isNumeric = true;
                    } 
                    catch (Exception e)
                    {   isNumeric = false;  }
                } while (!Validation.checkPosition(xPos, Integer.parseInt(info[0]), isNumeric));            
                System.out.println("Ship y Position (0 - " + (Integer.parseInt(info[0])) + "): ");
                do {
                    try {
                        yPos = Input.readIntFromKeyBoard();
                        isNumeric = true;
                    } 
                    catch (Exception e)
                    {   isNumeric = false;  }
                } while (!Validation.checkPosition(yPos, Integer.parseInt(info[0]), isNumeric));
                xRepeatPos = playerShips.getShipXPosition(playerShips.getShips(), Integer.parseInt(info[0])-1);
                yRepeatPos = playerShips.getShipYPosition(playerShips.getShips(), Integer.parseInt(info[0])-1);
            } while (!Validation.checkRepeatPos(xPos, yPos, xRepeatPos, yRepeatPos));
            playerShips.setShipInfo(ShipName, xPos, yPos);
        }
        
    }
    
    public void gameEntrence()
    {
        welcomeToGame();
        System.out.print('\u000C');
        loadingSettings();
    }
}
