
/**
 * Write a description of class Game here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Arrays;
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
    public void welcomeToGame(String[] info)
    {
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
            if (info[2].equals("true"))
                System.out.println("Computer Ships Visible : ON");
            else
                System.out.println("Computer Ships Visible : OFF");            
            System.out.println("Press any Key to continue...");
            Input.readFromKeyBoard();
        }
    }
    
    //  method for loading the settings
    public void loadingSettings(String[] info)
    {
        String ShipName = "";
        int xPos = 0;
        int yPos = 0;
        boolean isNumeric = false;
        
        System.out.println("Loading player settings:");
        // Loading the player's settings, including validation check, repeated position check
        for (int i = 1; i <= Integer.parseInt(info[3]); i++)
        {
            System.out.println("Please enter the details for the " + i + " ship:");
            System.out.println("ShipName:");
            do {
                ShipName = Input.readStringFromKeyBoard();
            } while (!Validation.checkShipName(ShipName));
            
            do {
                
                System.out.println("Ship x Position (0 - " + (Integer.parseInt(info[0])-1) + "): ");
                do {
                    try {
                        xPos = Input.readIntFromKeyBoard();
                        isNumeric = true;
                    } 
                    catch (Exception e)
                    {   isNumeric = false;  }
                } while (!Validation.checkPosition(xPos, Integer.parseInt(info[0]), isNumeric)); 
                
                System.out.println("Ship y Position (0 - " + (Integer.parseInt(info[0])-1) + "): ");                
                do {
                    try {
                        yPos = Input.readIntFromKeyBoard();
                        isNumeric = true;
                    } 
                    catch (Exception e)
                    {   isNumeric = false;  }
                } while (!Validation.checkPosition(yPos, Integer.parseInt(info[0]), isNumeric));
                if (!playerShips.getShipPosition(playerShips.getShips(), xPos, yPos))
                {
                    System.out.println("Position has already been taken!");
                }
            } while (!playerShips.getShipPosition(playerShips.getShips(), xPos, yPos));
            playerShips.setShipInfo(ShipName, xPos, yPos);
        }
        System.out.println("Successfully loading player Settings~~\n\n");
        
        System.out.println("Loading computer settings: ");
        loadingComSetting(info);
        System.out.println("Computer settings generated!");
        System.out.println("Press any Key to continue...");
        Input.readFromKeyBoard();        
    }
    
    // Loading the Computer's settings randomly, including repeated position check
    public void loadingComSetting(String[] info)
    {
        int CxPoS;
        int CyPos;
        CoordinateGenerator randomCoordinate = new CoordinateGenerator();
        
        for (int i = 1; i <= Integer.parseInt(info[3]); i++)
        {
            do {                
                CxPoS = randomCoordinate.generateCoordinate(0, Integer.parseInt(info[0])-1);
                CyPos = randomCoordinate.generateCoordinate(0, Integer.parseInt(info[0])-1);
            } while (!computerShips.getShipPosition(computerShips.getShips(), CxPoS, CyPos));              
            computerShips.setShipInfo("CompShip", CxPoS, CyPos);
        }
    }
    
    public void battleGround(String[] info, int round, int playerScore, int computerScore)
    {
        System.out.println("Beginning Round " + round);
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Displaying the Player Grid");
        for (int i = 0; i < Integer.parseInt(info[0]); i++)
        {
            for (int j = 0; j < Integer.parseInt(info[0]); j++)
            {
                if (playerShips.getShipStatus(playerShips.getShips(), i, j) == 3)
                    System.out.print("O");
                else if (playerShips.getShipStatus(playerShips.getShips(), i, j) == 1)
                    System.out.print("D");
                else if (playerShips.getShipStatus(playerShips.getShips(), i, j) == 2)
                    System.out.print("X");
                else
                    System.out.print("~");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        
        System.out.println("Displaying the Computer Grid");
        for (int i = 0; i < Integer.parseInt(info[0]); i++)
        {
            for (int j = 0; j < Integer.parseInt(info[0]); j++)
            {
                if(info[2].equals("true"))
                {
                    if (computerShips.getShipStatus(computerShips.getShips(), i, j) == 3)
                        System.out.print("O");
                    else if (computerShips.getShipStatus(computerShips.getShips(), i, j) == 1)
                        System.out.print("D");
                    else if (computerShips.getShipStatus(computerShips.getShips(), i, j) == 2)
                        System.out.print("X");
                    else
                        System.out.print("~");
                }
                else
                    System.out.print("~");
            }
            System.out.println();
        }        
    }
    
    public void guessTheCoordinate(String[] info)
    {
        int playerGuessX;
        int playerGuessY;
        int computerGuessX;
        int computerGuessY;
        CoordinateGenerator randomCoordinate = new CoordinateGenerator();
        
        System.out.println("Player to make a guess");
        System.out.println("Ship x Position (0 - " + (Integer.parseInt(info[0])-1) + ")");
        playerGuessX = Input.readIntFromKeyBoard();
        System.out.println("Ship y Position (0 - " + (Integer.parseInt(info[0])-1) + ")");
        playerGuessY = Input.readIntFromKeyBoard();
        if (!computerShips.getShipPosition(computerShips.getShips(), playerGuessX, playerGuessY))
        {
            System.out.println("PLAYER HITTTTTTT!!!!");
            computerShips.isShipHit(computerShips.getShips(), playerGuessX, playerGuessY);
        }
        else
            System.out.println("PLAYER MISSSSSSS!!!!");
            
        System.out.println("Computer to make a guess");
        computerGuessX = randomCoordinate.generateCoordinate(0, Integer.parseInt(info[0])-1);
        System.out.println("Computer x guess :" + computerGuessX);
        computerGuessY = randomCoordinate.generateCoordinate(0, Integer.parseInt(info[0])-1);
        System.out.println("Computer y guess :" + computerGuessY);
        if (!playerShips.getShipPosition(playerShips.getShips(), computerGuessX, computerGuessY))
        {
            System.out.println("Computer HITTTTTTT!!!!");
            playerShips.isShipHit(playerShips.getShips(), computerGuessX, computerGuessY);
        }
        else
            System.out.println("Computer MISSSSSSS!!!!");            
    }
    
    public void gameEntrence()
    {
        // Get the information from File
        FileIO readFile = new FileIO();
        String[] info = new String[4];        
        info = readFile.readingFromFile();
        int playerScore = 0;
        int computerScore = 0;
        int round = 1;
        
        welcomeToGame(info);
        System.out.print('\u000C');
        loadingSettings(info);
        System.out.print('\u000C');
        do {
            battleGround(info, round, playerScore, computerScore);
            guessTheCoordinate(info);
            round++;
            System.out.println("Press any Key to continue...");
            Input.readFromKeyBoard();
            System.out.print('\u000C');
        } while (computerShips.isAllShipX(computerShips.getShips()));
    }    
}
