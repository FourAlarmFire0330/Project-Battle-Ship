
/**
 * Write a description of class Validation here.
 * 
 * @ Tianyang Zhang - 28484452
 * @version (a version number or a date)
 */
public class Validation
{
    public Validation()
    {}
    
    public static boolean checkShipName(String shipName)
    {
        if (shipName.length() < 3 || shipName.length() > 15)
        {
            System.out.println("Must between 3 and 15 characters long! ");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static boolean checkPosition(int pos, int defaultSize, boolean isNumeric)
    {
        if ((pos < 0 || pos > defaultSize) && isNumeric == true)
        {
            System.out.println("Ship Positon Must be between 0 and " + defaultSize);
            return false;
        }
        else if (isNumeric == false)
        {
            System.out.println("Ship Position Must be Numeric!");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static boolean checkRepeatPos(int xPos, int yPos, int[] xP, int[] yP)
    {
        for (int i = 0; i < xP.length; i++)
        {
            if (xPos == xP[i])
            {
                for (int j = 0; j < yP.length; j++)
                {
                    if (yPos == yP[j])
                    {
                        System.out.println("Position has already been taken!");
                        System.out.println("Please re-enter~");
                        return false;
                    }
                }          
            }
        }
        return true;
    }
}
