package project1;
import java.util.ArrayList;

/**
 * Class interface with gift methods
 * @author maria ramlochan
 */
public interface Gift {
    /**
     * To find a random gift, could be a book, a stationery or a CD, the amount of 
     * that item will be decreased by one.
     * @param gifts the item in a gift array list
     * @return a random gift
     */
    public Item randomGift(ArrayList<Item> gifts); 
    
    /**
     * To find a random gift in that specific type, the user can choose if the type
     * is book, or stationery or cd.The amount of that item will be decreased by one. 
     * @param gifts the gift in an item array list
     * @param type type of item either book, or stationery or cd
     * @return the a random type of item
     */
    public Item randomGift(ArrayList<Item> gifts, String type);
    
    /**
     * To use point exchange for gift, also update the points of the user, the 
     * amount of that item will be decreased by one.
     * @param gifts the gift in an item array list
     * @return the points exchanged for gift
     */
    public Item pointToGift(ArrayList<Item> gifts, String itemNo);
} //End of class

