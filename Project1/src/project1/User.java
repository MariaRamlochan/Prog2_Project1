package project1;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Class to create a user
 * Subclass of Person
 * @author maria ramlochan
 */
public class User extends Person implements Gift {
    //Data members
    private Date dateOfBirth;
    private String id;
    private Address address;
    private int point;

    /**
     * Default constructor
     */
    public User() {
        super();
        this.dateOfBirth = new Date();
        this.id = "";
        this.address = new Address();
        this.point = 0;
    }

    /**
     * Constructor with name, gender, phoneNo, email, dateOfBirth, id and address
     * @param name the name of the user
     * @param gender the user's gender
     * @param phoneNo the user's phone number
     * @param email the user's email
     * @param dateOfBirth date of birth of the user
     * @param id the user's id
     * @param address the address of the user
     */
    public User(String name, String gender, String phoneNo, String email, 
            Date dateOfBirth, String id, Address address) {
        super(name, gender, phoneNo, email);
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.address = address;
    }

    /**
     * Copy constructor
     * @param user the user
     */
    public User(User user) {
        super(user);
        this.dateOfBirth = new Date(user.dateOfBirth.getDate());
        this.id = user.id;
        this.address = new Address(user.address);
        this.point = user.point;
    }
    
    /**
     * To find a random gift, could be a book, a stationery or a CD, the amount of 
     * that item will be decreased by one.
     * @param gifts the gift in an item array list
     * @return a random gift
     */
    @Override
    public Item randomGift(ArrayList<Item> gifts) {
        int randomGift = new Random().nextInt(gifts.size());
        for (Item item : gifts) {
            if (item instanceof Book || item instanceof CD 
                    || item instanceof Stationery)
                item.amount--;
        }
        return gifts.get(randomGift);
    }

    /**
     * To find a random gift in that type, the user can choose if the type is book,
     * or stationery or cd. The amount of that item will be decreased by one.
     * @param gifts the gift in an item array list
     * @param type type of item either book, or stationery or cd
     * @return the a random type of item
     */
    @Override
    public Item randomGift(ArrayList<Item> gifts, String type) {
         ArrayList<Item> giftList = new ArrayList<>();
        for (Item item : gifts) {
            if (item instanceof Book) {
                if (type.toLowerCase().equals("book")) {
                    giftList.add(item);   
                }
            }
            if (item instanceof CD) {
                if (type.toLowerCase().equals("cd")) {
                    giftList.add(item);   
                }
            }
            if (item instanceof Stationery) {

                if (type.toLowerCase().equals("stationery")) {
                    giftList.add(item);
                }
            }
            item.amount--; 
        }
        int randomGift = new Random().nextInt(giftList.size());
        return giftList.get(randomGift);
    }

    /**
     * To use point exchange for gift, also update the points of the user, the 
     * amount of that item will be decreased by one.
     * @param gifts the gift in an item array list
     * @param itemNo the item number
     * @return the points exchanged for gift
     */
    @Override
    public Item pointToGift(ArrayList<Item> gifts, String itemNo) {
        Item gift = null;
        if (point >= 200) {
            for (Item item : gifts)
                if (item.itemNo.equals(itemNo))
                    gift = item; 
            setPoint(point -= 200);
        }
        return gift;
    }

    /**
     * HashCode method
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + super.hashCode();
        hash = 19 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + this.point;
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
        final User other = (User) obj;
        if (!super.equals(obj))
            return false;
        if (this.point != other.point) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
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
        str += String.format("%-10s: %s\n", "Date of Birth: ", dateOfBirth);       
        str += String.format("%-10s: %s\n", "ID: ", id);     
        str += String.format("%-10s: %s\n", "Address: ", address);     
        str += String.format("%-10s: %s\n", "Points: ", point);       
        return str;
    }

    //Getters
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getId() {
        return id;
    }
    public Address getAddress() {
        return address;
    }
    public int getPoint() {
        return point;
    }

    //Setters
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setPoint(int point) {
        this.point = point;
    }
} //End of class
