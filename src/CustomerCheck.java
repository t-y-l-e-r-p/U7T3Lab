
import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
            double total = 0.0;
            for(int t = 0; t < check.size(); t++)
            {
                double work = check.get(t).getPrice();
                total += work;
            }
            return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        for(int z = 0; z < check.size(); z++)
        {
            if(check.get(z).isDailySpecial())
            {
                return false;
            }
        }
        if(totalPrices()<40)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        int entree = 0;
        double checkCost = totalPrices();
        for(int i = 0; i < check.size(); i++)
        {
            if(check.get(i).isEntree())
            {
                entree++;
            }
        }
        if(entree >= 6)
        {
            checkCost = checkCost * 1.2;
        }
        if(couponApplies())
        {
            checkCost = checkCost * 0.75;
        }
        return checkCost;

    }

}
