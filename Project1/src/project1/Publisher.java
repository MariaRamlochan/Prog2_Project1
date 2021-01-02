package project1;
import java.util.Objects;

/**
 * Simple class for creating a publisher of a book
 * @author maria ramlochan
 */
public class Publisher {
    //Data members
    private String name;
    private Person contact;
    private Address address;

    /**
     * Default constructor
     */
    public Publisher() {
        this.name = "";
        this.contact = new Person();
        this.address = new Address();
    }
    
    /**
     * Constructor with all data members
     * @param name the name of the publisher
     * @param contact the contact information
     * @param address the address of a person
     */
    public Publisher(String name, Person contact, Address address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
    
    /**
     * Copy constructor
     * @param publisher the publisher
     */
    public Publisher(Publisher publisher) {
        this.name = publisher.name;
        this.contact = new Person(publisher.contact);
        this.address = new Address(publisher.address);
    }

    /**
     * HashCode for all data members
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.contact);
        hash = 79 * hash + Objects.hashCode(this.address);
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
        final Publisher other = (Publisher) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
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
        str += String.format("%-10s: %s\n", "Publisher Name: ", name);
        str += String.format("%-10s: %s\n", "Contact: ", contact);
        str += String.format("%-10s: %s\n", "Addres: ", address);       
        return str;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Person getContact() {
        return contact;
    }
    public Address getAddress() {
        return address;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setContact(Person contact) {
        this.contact = contact;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
} //End of class
