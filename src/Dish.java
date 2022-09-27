/**
 * CSCI 1110 – Assignment 02
 * @author Bhavya G.
 * Bhavya Ghevariya – B00872733
 * This is a class of Dish which creates an object Dish and manipulates it with methods
 */

public class Dish {

    //Declaration of the variables
    private String name;
    private double price;

    /**
     * This constructor creates a new dish object
     * @param dishName a string to store the dish name
     * @param dishPrice a double to store the dish price
     */
    public Dish(String dishName, double dishPrice)
    {
        this.name = dishName;
        this.price = dishPrice;
    }

    /**
     * This method return the name of the dish
     * @return name a dish name as string
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method returns the price of the dish
     * @return price as double
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * This method coverts the dish to a string and returns it
     * @return a conversion of the dish object as a string
     */
    public String toString()
    {
        return name + " - " +  String.format("%.2f", price) + " CAD";
    }
}
