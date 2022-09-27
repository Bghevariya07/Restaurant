/**
 * CSCI 1110 – Assignment 02
 * @author Bhavya G.
 * Bhavya Ghevariya – B00872733
 * This is a class of Restaurant which creates an object Restauranr and manipulates it with methods
 */

import java.util.ArrayList;

public class Restaurant {

    //Declaration of the varibales
    private ArrayList<Dish> menu = new ArrayList<>();
    static private ArrayList<Table> tables = new ArrayList<>();
    private double totalSalesValue;
    private String RESATAURANT_NAME;
    private static int tableNumber = 1;

    /**
     * This is a Restaurant constructor which creates a restaurant object
     * @param RESATAURANT_NAME a String with the name of the restaurant
     */
    public Restaurant(String RESATAURANT_NAME)
    {
        this.RESATAURANT_NAME = RESATAURANT_NAME;
    }

    /**
     * This method returns an arraylist of a menu
     * @return an arrayList containing the dishes
     */
    public ArrayList<Dish> getMenu()
    {
        return menu;
    }

    /**
     * This method returns a table object when it is called by the table number
     * @param tableNumber an integer containing the table number
     * @return a table object which is found according to the table number parameter
     */
    public Table getTableByNumber(int tableNumber)
    {
        if (tableNumber <= tables.size())
        {
            return tables.get(tableNumber);
        }
        return null;
    }

    /**
     * This method adds a dish to the menu
     * It first creates a dish object with name and price of the dish and then it adds to the menu
     * @param name a string with the name of the dish
     * @param price a double with the price of the dish
     */
    public void addDishToMenu(String name, double price)
    {
        Dish newDish = new Dish(name,price);
        this.menu.add(newDish);
    }

    /**
     * This method creates a table by the size of the table
     * The table number starts from 1 and will be added to the following number
     * @param size the size of the table which will be created
     */
    public void createTable(int size)
    {
        tables.add(0,null);
        Table newTable = new Table(size, tableNumber);
        tables.add(tableNumber, newTable);
        tableNumber++;
    }

    /**
     * This method prints the menu including index umber, item name, and price
     */
    public void printMenu()
    {
        for (int i = 0; i < menu.size(); i++)
        {
            System.out.println( (i+1) + " - " + menu.get(i) );
        }
    }

    /**
     * This method closes the table by its table number and calculates the total sales value
     * @param tableNumber the table number which needs to be closed
     */
    public void closeTable(int tableNumber)
    {
        Table tableToClose = getTableByNumber(tableNumber);
        this.totalSalesValue += tableToClose.bill;
    }

    /**
     * This method returns the total revenue of the restaurant with its name
     * @return a string containing the restaurant name, and total revenue
     */
    public String toString()
    {
        return "Restaurant " + this.RESATAURANT_NAME + ", night revenue so far " + String.format("%.2f", totalSalesValue);
    }
}
