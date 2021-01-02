package project1;
import java.util.Date;
import java.util.Objects;

/**
 * Simple class for creating an employee
 * @author maria ramlochan
 */
public class Employee extends User{
    //Data members
    private static int nextEmployeeId;
    private double salary;
    private Date firstHiredDate;

    /**
     * Default constructor
     */
    public Employee() {
        super();
        Employee.nextEmployeeId = 0;
        this.salary = 0;
        this.firstHiredDate = new Date();
    }

    /**
     * Constructor with name, gender, phoneNo, email, dateOfBirth, address and salary
     * @param name the name of the employee
     * @param gender the employee's gender
     * @param phoneNo the employee phone number
     * @param email the employee's email
     * @param dateOfBirth the date of birth of the employee
     * @param address the address of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, String gender, String phoneNo, String email, 
            Date dateOfBirth, Address address, double salary) {
        super(name, gender, phoneNo, email, dateOfBirth, 
                String.format("E%06d", ++nextEmployeeId), address);
        this.salary = salary;
    }

    /**
     * Copy constructor
     * @param employee the employee
     */
    public Employee(Employee employee) {
        super(employee);
        Employee.nextEmployeeId = Employee.nextEmployeeId;
        this.salary = employee.salary;
        this.firstHiredDate = new Date(employee.firstHiredDate.getTime());
    }
    
    /**
     * Method to calculate an employee has worked
     * An employee gain one point every day after she/he gets hired. If she/he worked 
     * more than 1 year, every month adds 1 additional point. If she/he worked more
     * than 2 years, every month adds 2 additional points, so on so forth
     * @return the total number of points
     */
    public int calcPoint() {
        int points = 0, temp = 0, days = 0, years = 0, months = 12, totalDays;
        Date today = new Date();
        totalDays = (int)(((today.getTime() - firstHiredDate.getTime()) /           
                (24 * 60 * 60 * 1000)));
        if (today.getYear() % 4 == 0) 
            days = 366;
        else
            days = 365;
        for (int i = 0; i < totalDays; i++) {
            while(i == days + temp) {
                years++;
                temp = i; //store i in a temporary variable
                for (int y = 1; y < years; y++) 
                    for (int m = 0; m < months; m++) 
                        points++;
            }
            points++;
        }
        setPoint(points);
        return points;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + super.hashCode();
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.salary) ^ 
                (Double.doubleToLongBits(this.salary) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.firstHiredDate);
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
        final Employee other = (Employee) obj;
        if (!super.equals(obj))
            return false;
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.firstHiredDate, other.firstHiredDate)) {
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
        str += String.format("%-10s: %s\n", "Employee ID: ", nextEmployeeId);
        str += String.format("%-10s: %s\n", "Salary: ", salary);
        str += String.format("%-10s: %s\n", "First Day Hired: ", firstHiredDate);
        str += String.format("%-10s: %s\n", "Points: ", calcPoint());        
        return str;
    }

    //Getters
    public static int getNextEmployeeId() {
        return nextEmployeeId;
    }
    public double getSalary() {
        return salary;
    }
    public Date getFirstHiredDate() {
        return firstHiredDate;
    }

    //Setters
    public static void setNextEmployeeId(int nextEmployeeId) {
        Employee.nextEmployeeId = nextEmployeeId;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setFirstHiredDate(Date firstHiredDate) {
        this.firstHiredDate = firstHiredDate;
    }   
} //End of class
