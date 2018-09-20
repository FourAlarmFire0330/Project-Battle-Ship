/**
 * Write a description of class ShipList here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class ShipList
{
    /**
     * Fields
     */
    private ArrayList<Ship> ships;
    
    /**
     * Default Constructor
     */
    public ShipList()
    {
        ships = new ArrayList<Ship>();
    }
    
    /**
     * Accessor and Mutator Methods
     */
    public void setShips(ArrayList<Ship> ships)
    {
        this.ships = ships;
    }
    public ArrayList<Ship> getShips()
    {
        return ships;
    }
    
    public void setShipInfo(String shipName, int xPos, int yPos)
    {
        Ship ship = new Ship();
        ship.setShipName(shipName);
        ship.setXPos(xPos);
        ship.setYPos(yPos);
        ships.add(ship);
    }
    
    public int[] getShipXPosition(ArrayList<Ship> ships, int x)
    {
        int[] xPos = new int[x];
        int i = 0;
        for (Ship s : ships)
        {
            xPos[i] = s.getXPos();
            i++;
        }
        return xPos;
    }
    
    public int[] getShipYPosition(ArrayList<Ship> ships, int y)
    {
        int[] yPos = new int[y];
        int i = 0;
        for (Ship s : ships)
        {
            yPos[i] = s.getYPos();
            i++;
        }
        return yPos;
    }    
}
