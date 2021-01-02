package project1;
import java.util.Objects;

/**
 * Simple Person class 
 * Parent class of User
 * @author maria ramlochan
 */
public class Person {
    //Data members
    private String name;
    private String gender;
    private String phoneNo;
    private String email;
    
    /**
     * Default constructor
     */
    public Person() {
        this.name = "";
        this.gender = "";
        this.phoneNo = "";
        this.email = "";
    }

    /**
     * Constructor with all data members
     * @param name the name of the person
     * @param gender the person's gender
     * @param phoneNo the person's phone number
     * @param email the person's email
     */
    public Person(String name, String gender, String phoneNo, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    
    /**
     * Copy constructor
     * @param person a person
     */
    public Person(Person person) {
        this.name = person.name;
        this.gender = person.gender;
        this.phoneNo = person.phoneNo;
        this.email = person.email;
    }

    /**
     * HashCode for all data members
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.gender);
        hash = 89 * hash + Objects.hashCode(this.phoneNo);
        hash = 89 * hash + Objects.hashCode(this.email);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
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
        str += String.format("%-10s: %s\n", "Name: ", name);
        str += String.format("%-10s: %s\n", "Gender: ", gender);
        str += String.format("%-10s: %s\n", "Phone Number: ", phoneNo);
        str += String.format("%-10s: %s\n", "Email: ", email);        
        return str;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getEmail() {
        return email;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void setEmail(String email) {
        this.email = email;
    }  
} //End of class
