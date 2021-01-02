package project1;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * Class to create an item of a Book Store
 * @author maria ramlochan
 */
public class Item {
    //Data members
    protected String itemNo;
    protected Date firstCreatedDate;
    protected double price;
    protected int amount;
    protected String category;
    
    /**
     * Default constructor
     */
    public Item() {
        this.itemNo = "";
        this.firstCreatedDate = new Date();
        this.price = 0;
        this.amount = 0;
        this.category = "";
    }
    
    /**
     * Constructor with all data members
     * @param itemNo the item number
     * @param price the price of the item
     * @param amount the amount of item
     * @param category the category of the item
     */
    public Item(String itemNo, double price, int amount, String category) {
        this.itemNo = itemNo;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.firstCreatedDate = Date.from(Instant.now()); //Current date and time
    }
    
    /**
     * Copy constructor
     * @param item the item
     */
    public Item(Item item) {
        this.itemNo = item.itemNo;
        this.firstCreatedDate = new Date(item.firstCreatedDate.getTime());
        this.price = item.price;
        this.amount = item.amount;
        this.category = item.category;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ 
                (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.category);
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
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
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
        str += String.format("%-10s: %s\n", "Item Number: ", itemNo);
        str += String.format("%-10s: %s\n", "First Created Date: ", firstCreatedDate);
        str += String.format("%-10s: %s\n", "Price: ", price);
        str += String.format("%-10s: %s\n", "Amount: ", amount);        
        str += String.format("%-10s: %s\n", "Category: ", category); 
        return str;
    }

    //Getters
    public String getItemNo() {
        return itemNo;
    }
    public Date getFirstCreatedDate() {
        return firstCreatedDate;
    }
    public double getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }

    //Setters
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
    public void setFirstCreatedDate(Date firstCreatedDate) {
        this.firstCreatedDate = firstCreatedDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setCategory(String category) {
        this.category = category;
    }
} //End of class
