package project1;
import java.util.Objects;

/**
 * Simple class to create an address
 * @author maria ramlochan
 */
public class Address {
    //Data members
    private int streetNo;
    private String street;
    private String city;
    private String zipCode;
    
    /**
     * Default constructor
     */
    public Address() {
        this.streetNo = 0;
        this.street = "";
        this.city = "";
        this.zipCode = "";
    }

    /**
     * Constructor with all data members
     * @param streetNo the street number in an address
     * @param street the street in an address
     * @param city the city in an address
     * @param zipCode the zip code in an address
     */
    public Address(int streetNo, String street, String city, String zipCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    /**
     * Copy constructor
     * @param address the address
     */
    public Address(Address address) {
        this.streetNo = address.streetNo;
        this.street = address.street;
        this.city = address.city;
        this.zipCode = address.zipCode;
    }

    /**
     * HashCode for all data members
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.streetNo;
        hash = 53 * hash + Objects.hashCode(this.street);
        hash = 53 * hash + Objects.hashCode(this.city);
        hash = 53 * hash + Objects.hashCode(this.zipCode);
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
        final Address other = (Address) obj;
        if (this.streetNo != other.streetNo) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
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
        str += String.format("%-10s: %s\n", "Street Number: ", streetNo);
        str += String.format("%-10s: %s\n", "Street: ", street);
        str += String.format("%-10s: %s\n", "City: ", city);
        str += String.format("%-10s: %s\n", "ZipCode: ", zipCode);        
        return str;
    }

    //Getters
    public int getStreetNo() {
        return streetNo;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getZipCode() {
        return zipCode;
    }
    
    //Setters
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    } 
} //End of class
