
/**
 * Write a description of class Ship here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
public class Ship
{
    /**
     * Fields
     */
    private String shipName;
    private int xPos;
    private int yPos;
    private int noOfHitsMade;
    private int noOfHitsNeeded;
    
    /**
     * Default Constructor
     */
    public Ship()
    {
        shipName = "Default";
        xPos = 0;
        yPos = 0;
        noOfHitsMade = 0;
        noOfHitsNeeded = 5;
    }
    
    /**
     * Accessor and Mutator methods
     */
    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }
    public String getShipName()
    {
        return shipName;
    }
    
    public void setXPos(int xPos)
    {
        this.xPos = xPos;
    }
    public int getXPos()
    {
        return xPos;
    }
    
    public void setYPos(int yPos)
    {
        this.yPos = yPos;
    }
    public int getYPos()
    {
        return yPos;
    }
    
    public void setNoOfHitsMade(int noOfHitsMade)
    {
        this.noOfHitsMade = noOfHitsMade;
    }
    public int getNoOfHitsMade()
    {
        return noOfHitsMade;
    }
    
    public void setNoOfHitsNeeded(int noOfHitsNeeded)
    {
        this.noOfHitsNeeded = noOfHitsNeeded;
    }
    public int getNoOfHitsNeeded()
    {
        return noOfHitsNeeded;
    }    
}
