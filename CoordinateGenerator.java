
/**
 * Write a description of class CoordinateGenerator here.
 * 
 * @ Tianyang Zhang
 * @version (a version number or a date)
 */
public class CoordinateGenerator
{
    /**
     * Fields
     */
    private int minimumValue;
    private int maximumValue;
    
    /**
     * Default Constructor
     */
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 100;
    }
    
    /**
     * Accessor and Mutator methods
     */
    public void setMinimum(int minimumValue)
    {
        this.minimumValue = minimumValue;
    }
    public int getMinimum()
    {
        return minimumValue;
    }
    
    public void setMaximum(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
    public int getMaximum()
    {
        return maximumValue;
    }
    
    //Generate the randomNumber within a range
    public int generateCoordinate(int minimumValue, int maximumValue)
    {        
        int randomNumber = minimumValue + (int)(Math.random() * (maximumValue - minimumValue));
        return randomNumber;
    }     
}
