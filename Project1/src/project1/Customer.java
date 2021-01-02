package project1;
import java.util.Date;

/**
 * Simple class for creating a customer
 * @author maria ramlochan
 */
public class Customer extends User{
    //Data members
    private int vipLevel;
    private static int nextCustomerId;

    /**
     * Default constructor
     */
    public Customer() {
        super();
        this.vipLevel = 0;
        Customer.nextCustomerId = 0;
    }

    /**
     * Constructor with name, gender, phoneNo, email, dateOfBirth, address and salary
     * @param name the name of the customer
     * @param gender the customer's gender
     * @param phoneNo the customer's phone number
     * @param email the email of the customer
     * @param dateOfBirth the date of birth of the customer
     * @param address the customer's address
     */
    public Customer(String name, String gender, String phoneNo, String email, 
            Date dateOfBirth, Address address) {
        super(name, gender, phoneNo, email, dateOfBirth, 
                String.format("U%06d", ++nextCustomerId), address);
    }

    /**
     * Copy constructor
     * @param customer the customer
     */
    public Customer(Customer customer) {
        super(customer);
        this.vipLevel = customer.vipLevel;
        Customer.nextCustomerId = Customer.nextCustomerId;
    }
    
    /**
     * Method to calculate the points of a customer
     * If the customer is not a VIP, then each dollar spends gain 1 point,
     * ignore the decimal part. If the customer is Regular VIP, 5% additional
     * points gains. If the customer is Golden VIP, 10% additional points gains.
     * If the customer is Diamond VIP, 15% additional points gains, and if the point
     * total for the specific purchase is above 200, another 20 points will be added
     * @param amountSpent the total amount spent by the customer
     * @return the points of the customer
     */
    public int calcPoint(double amountSpent) {
        int points = 0;
        double REGULAR_VIP = 0.5;
        double GOLDEN_VIP = 0.10; 
        double DIAMOND_VIP = 0.15;
        if (vipLevel == 0)
            points = (int) amountSpent;
        if (vipLevel == 1)
            points = (int) amountSpent + (int) (amountSpent * REGULAR_VIP);
        if (vipLevel == 2)
            points = (int) amountSpent + (int) (amountSpent * GOLDEN_VIP);
        if (vipLevel == 3)
            if (amountSpent > 200)
                points = (int) amountSpent + (int) (amountSpent * DIAMOND_VIP + 20);
            else
                points = (int) amountSpent + (int) (amountSpent * DIAMOND_VIP);
        return points;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + super.hashCode();
        hash = 83 * hash + this.vipLevel;
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
        final Customer other = (Customer) obj;
        if (!super.equals(obj))
            return false;
        if (this.vipLevel != other.vipLevel) {
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
        str += super.toString();
        str += String.format("%-10s: %s\n", "Customer ID: ", nextCustomerId);
        str += String.format("%-10s: %s\n", "VIP Level: ", vipLevel);    
        return str;
    }

    //Getters
    public int getVipLevel() {
        return vipLevel;
    }
    public static int getNextCustomerId() {
        return nextCustomerId;
    }
    
    //Setters
    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }
    public static void setNextCustomerId(int nextCustomerId) {
        Customer.nextCustomerId = nextCustomerId;
    }
} //End of class
