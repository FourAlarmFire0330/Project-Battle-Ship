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

    public boolean getShipPosition(ArrayList<Ship> ships, int x, int y)
    {
        for (Ship s : ships)
        {
            if (x==s.getXPos() && y==s.getYPos())
            {
                return false;
            }
        }
        return true;
    }
    
    public int getShipStatus(ArrayList<Ship> ships, int x, int y)
    {
        for (Ship s : ships)
        {
            if (x==s.getXPos() && y==s.getYPos())
            {
                if (s.getNoOfHitsMade() >= 1)
                {
                    if (s.getNoOfHitsMade()==s.getNoOfHitsNeeded())
                    {
                        return 2;
                    }
                    return 1;
                }
                else
                    return 3;
            }
        }
        return 0;
    }
    
    public void isShipHit(ArrayList<Ship> ships, int x, int y)
    {
        for (Ship s : ships)
        {
            if (x==s.getXPos() && y==s.getYPos())
            {
                s.setNoOfHitsMade(1);
            }
        }        
    }
    
    public boolean isAllShipX(ArrayList<Ship> ships)
    {
        int i = 0;
        for (Ship s : ships)
        {
            if (s.getNoOfHitsMade()==s.getNoOfHitsNeeded())
            {
                i++;
            }
        }
        if (i==3)
        {
            return false;
        }
        return true;
    }
}
