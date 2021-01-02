package project1;
import java.util.Objects;

/**
 * Simple class for stationery item
 * Subclass of Item
 * @author maria ramlochan
 */
public class Stationery extends Item{
    //Data members
    protected String name;
    protected static int nextStationeryNo;

    /**
     * Default constructor
     */
    public Stationery() {
        super();
        this.name = "";
        Stationery.nextStationeryNo = 0;
    }

    /**
     * Constructor with name, price, amount and category
     * @param name the name of the stationery
     * @param price price of the stationery
     * @param amount amount of stationery
     * @param category the category of the stationery
     */
    public Stationery(String name, double price, int amount, String category) {
        super(String.format("S%06d", ++nextStationeryNo), price, amount,
                category.toLowerCase());
        this.name = name;
        if (category.equals("pen") || category.equals("notebook") || 
                category.equals("card") || category.equals("others")) 
            ; //Do nothing
        else
            System.out.println("Not a valid Category");
    }

    /**
     * Copy constructor
     * @param stationery the stationery
     */
    public Stationery(Stationery stationery) {
        super(stationery);
        this.name = stationery.name;
        Stationery.nextStationeryNo = Stationery.nextStationeryNo;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + super.hashCode();
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Stationery.nextStationeryNo;
        return hash;
    }

    /**
     * Equals method
     * @param obj an object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stationery other = (Stationery) obj;
        if (!super.equals(obj))
            return false;
        if (Stationery.nextStationeryNo != Stationery.nextStationeryNo) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    /**
     * ToString method
     * @return a String
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("%-10s: %s\n", "Stationery Name: ", name);             
        return str;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getNextStationeryNo() {
        return nextStationeryNo;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNextStationeryNo(int nextStationeryNo) {
        Stationery.nextStationeryNo = nextStationeryNo;
    }  
} //End of class
