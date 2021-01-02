package project1;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * BookStore class to store array list of items, employees, customers and gifts
 * @author maria ramlochan
 */
public class BookStore {    
    //Data members
    private ArrayList<Item> items;
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;
    private ArrayList<Item> gifts;
    
    /**
     * Default constructor
     */
    public BookStore() {
        this.items = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.gifts = new ArrayList<>();
    }

    /**
     * Constructor with all perimeters 
     * @param items the items in an array list
     * @param employees the employees in an array list
     * @param customers the customers in an array list
     * @param gifts the gifts for customer and employee in an array list
     */
    public BookStore(ArrayList<Item> items, ArrayList<Employee> employees, 
            ArrayList<Customer> customers, ArrayList<Item> gifts) {
        this.items = items;
        this.employees = employees;
        this.customers = customers;
        this.gifts = gifts;
    }
    
    /**
     * Copy constructor
     * @param bookStore the book store
     */
    public BookStore(BookStore bookStore) {
        this.items = new ArrayList<>(bookStore.items);
        this.employees = new ArrayList<>(bookStore.employees);
        this.customers = new ArrayList<>(bookStore.customers);
        this.gifts = new ArrayList<>(bookStore.gifts);
    }
    
    /**
     * To add an item into the items list. If the item already exists, remind the
     * user: "This item already exists, do you want to update its amount?" If the
     * answer is "yes" or "y", then update the amount, else ignore it. If the item
     * does not exist, then directly add the item into the items.
     * @param item an item from Item class
     * @return false
     */
    public boolean addProduct(Item item) {
        Scanner sc = new Scanner(System.in);
        if (item.equals(item)) {
            System.out.println("This item already exists" + 
                    "\nDo you want to update its amount?");
            String answer = sc.nextLine();
            if (answer.toLowerCase().startsWith("y"))
                item.amount++;
            else
                return false;
        } else
            items.add(item);
        return false;
    }
    
    /**
     * To add an employee into the employees list. If the employee exists already, 
     * then do not add the new one into the list and print a message: "The employee
     * is already in the list" and return false.
     * @param employee an employee from Employee class
     * @return false
     */
    public boolean addEmployee(Employee employee) {
        if (employee.equals(employee))
            System.out.println("The Employee is already in the list");
        else
            employees.add(employee);
        return false;
    }

    /**
     * To add a customer into the customers list. If the customer exists already, 
     * then do not add the new one into the list and print a message: "The customer
     * is already in the list" and return false
     * @param customer a customer from Customer class
     * @return false
     */
    public boolean addCustomer(Customer customer) {
        if (customer.equals(customer))
            System.out.println("The Customer is already in the list");
        else 
            customers.add(customer);
        return false;
    }

    /**
     * To update the VIP level of a customer. find the customer with a specific ID 
     * and change its VIP level. It will print the original information of a 
     * customer and ask the user to confirm the change. if the answer is "y" or 
     * "yes", then update the VIP level, else ignore the update and return false. 
     * If the customer does not exist, it will print "ID: [id] does not exist", and
     * then return false.
     * @param id the id of the customer
     * @param vipLevel the VIP level of the customer
     * @return false
     */
    public boolean updateVip(String id, int vipLevel) {
        Scanner sc = new Scanner(System.in);
        if (id.equals(id)) {
            System.out.println("Do you want to update VIP level?");
            String answer = sc.nextLine();
            if (answer.toLowerCase().startsWith("y"))
                vipLevel++;
            else 
                return false;
        } else
            System.out.println("ID " + id + " does not exist");
        return false;
    }
    
    /**
     * To search a keyword in items. If the title of a book contains the keyword, 
     * add it to the result, if the name of a stationery contains the keyword, add 
     * it to the result, if the name of a cd contains the keyword, 
     * add it to the result. 
     * @param keyword the keyword inputted by the user
     * @return the result
     */
    public ArrayList<Item> searchItem(String keyword) {
        keyword.toLowerCase();
        ArrayList result = new ArrayList<>();
        for (Item item : items)
            if (item instanceof Book || item instanceof CD 
                    || item instanceof Stationery) {
                    Book book = (Book)item;
                    CD cd = (CD)item;
                    Stationery stationery = (Stationery)item;
                    if (book.getTitle().contains(keyword) 
                            || cd.getName().contains(keyword) 
                            || stationery.getName().contains(keyword))
                        ; // Do nothing
                    result.add(item);
                    item.amount++;
                }
        return result;
    }
    
    /**
     * searchCustomer method: To search a keyword in customers. If the name, id, 
     * phone number, or email of a customer contains the keyword,
     * add it to the result.
     * @param keyword the keyword inputted by the user
     * @return the result
     */
    public ArrayList<Customer> searchCustomer(String keyword) {
        keyword.toLowerCase();
        ArrayList result = new ArrayList<>();
        for (Customer customer : customers)
            if (customer.getName().contains(keyword) 
                    || customer.getId().contains(keyword) 
                    || customer.getPhoneNo().contains(keyword) 
                    || customer.getEmail().contains(keyword))
                result.add(customer);
        return result;
    }
    
    /**
     * To sell items. it will update the item amount, find the total price 
     * the customer has to pay, also update her or his points.
     * @param id the ID of a customer
     * @param items the items in an array list
     * @return the total of the customer
     */
    public double checkout(String id, ArrayList<Item> items) {
        double total = 0;
        Customer customer = new Customer();
        for (Item item : items) {
            total += item.getPrice();
            item.amount--;
            if (customer.getId().equals(id))
                customer.calcPoint(total);
        }
        return total;
    }
    
    /**
     * To find the user who has a birthday today. If today is a user's birthday, 
     * add the user to the list and return it.
     * @return the list of user who have birthday the current day
     */
    public ArrayList<User> findBirthdayDayUser() {
        ArrayList<User> list = new ArrayList<>();
        Date today = new Date();
        for (User user : customers)
            if (user.getDateOfBirth().getDate() == today.getDate())
                list.add(user);
        return list;
    }
} //End of class
