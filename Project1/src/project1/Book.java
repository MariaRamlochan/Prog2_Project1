package project1;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Simple class for creating book item
 * Subclass of Item
 * @author maria ramlochan
 */
public class Book extends Item{
    //Data members
    protected String title;
    protected ArrayList<Person> authors;
    protected String isbn;
    protected Publisher publisher;
    protected static int nextBookNo;
    
    /**
     * Default constructor
     */
    public Book() {
        super();
        this.title = "";
        this.authors = new ArrayList<>();
        this.isbn = "";
        this.publisher = new Publisher();
        Book.nextBookNo = 0;
    }

    /**
     * Constructor with tittle, authors, ISBN, publisher, price, amount and category
     * @param title the title of the book
     * @param authors the authors of the book
     * @param isbn the ISBN of the book
     * @param publisher the publisher of the book
     * @param price the price of the book
     * @param amount the amount of book
     * @param category the category of the book
     */
    public Book(String title, ArrayList<Person> authors, String isbn, 
            Publisher publisher, double price, int amount, String category) {
        super(String.format("B%06d", ++nextBookNo), price, amount, 
                category.toLowerCase());
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        if (category.equals("history") || category.equals("science") || 
                category.equals("cook") || category.equals("art") ||
                category.equals("sport") || category.equals("others")) 
            ; //Do nothing
        else
            System.out.println("Not a valid Category");
    }

    /**
     * Copy constructor
     * @param book the book
     */
    public Book(Book book) {
        super(book);
        this.title = book.title;
        this.authors = new ArrayList<>(book.authors);
        this.isbn = book.isbn;
        this.publisher = book.publisher;
        Book.nextBookNo = Book.nextBookNo;
    }

    /**
     * HashCode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + super.hashCode();
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.authors);
        hash = 53 * hash + Objects.hashCode(this.isbn);
        hash = 53 * hash + Objects.hashCode(this.publisher);
        hash = 53 * hash + Book.nextBookNo;
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
        final Book other = (Book) obj;
        if (!super.equals(obj))
            return false;
        if (Book.nextBookNo != Book.nextBookNo) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }

    /**
     * ToString method
     * @return a string
     */
    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += String.format("%-10s: %s\n", "Title: ", title);
        str += String.format("%-10s: %s\n", "Authors: ", authors);
        str += String.format("%-10s: %s\n", "ISBN: ", isbn);
        str += String.format("%-10s: %s\n", "Publisher: ", publisher);               
        return str;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public ArrayList getAuthors() {
        return authors;
    }
    public String getIsbn() {
        return isbn;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public int getNextBookNo() {
        return nextBookNo;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public void setNextBookNo(int nextBookNo) {
        Book.nextBookNo = nextBookNo;
    }  
} //End of class
