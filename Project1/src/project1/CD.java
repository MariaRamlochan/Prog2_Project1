package project1;
import java.util.Objects;

/**
 * Simple class for creating CD item
 * Subclass of Item
 * @author maria ramlochan
 */
public class CD extends Item{
    //Data members
    protected String name;
    protected Person artist;
    protected Publisher publisher;
    protected static int nextCdNo;

    /**
     * Default constructor
     */
    public CD() {
        super();
        this.name = "";
        this.artist = new Person();
        this.publisher = new Publisher();
        CD.nextCdNo = 0;
    }

    /**
     * Constructor with name, price, amount and category
     * @param name the name of the stationery
     * @param price the price of the stationery
     * @param amount the amount of stationery
     * @param category the category of the stationery
     */
    public CD(String name, double price, int amount, String category) {
        super(String.format("C%06d", ++nextCdNo), price, amount, 
                category.toLowerCase());
        this.name = name;
        if (category.equals("pop") || category.equals("classic") || 
                category.equals("jazz") || category.equals("new age") || 
                category.equals("soundtrack") || category.equals("others")) 
            ; //Do nothing
        else
            System.out.println("Not a valid Category");
    }

    /**
     * Copy constructor
     * @param cd the CD
     */
    public CD(CD cd) {
        super(cd);
        this.name = cd.name;
        this.artist = new Person(cd.artist);
        this.publisher = new Publisher(cd.publisher);
        CD.nextCdNo = CD.nextCdNo;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + super.hashCode();
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.artist);
        hash = 89 * hash + Objects.hashCode(this.publisher);
        hash = 89 * hash + CD.nextCdNo;
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
        final CD other = (CD) obj;
        if (!super.equals(obj))
            return false;
        if (CD.nextCdNo != CD.nextCdNo) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
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
        str += String.format("%-10s: %s\n", "CD Name: ", name);       
        str += String.format("%-10s: %s\n", "Artist: ", artist);     
        str += String.format("%-10s: %s\n", "Publisher: ", publisher);           
        return str;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Person getArtist() {
        return artist;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public int getNextCdNo() {
        return nextCdNo;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setArtist(Person artist) {
        this.artist = artist;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public void setNextCdNo(int nextCdNo) {
        CD.nextCdNo = nextCdNo;
    }   
} //End of class
