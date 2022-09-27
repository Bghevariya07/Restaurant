/**
 * CSCI 1110 – Assignment 02
 * @author Bhavya G.
 * Bhavya Ghevariya – B00872733
 * This is a class of Customer which creates an object Customer and manipulates it with methods
 */

import java.util.ArrayList;

public class Customer {

    //Declaration of the varibales
    private ArrayList<Dish> order = new ArrayList<>();
    private String name;

    /**
     * This Customer constructor creates a customer object usign a string name
     * @param name a string of the name of the customer
     */
    public Customer(String name)
    {
        this.name = name;
    }

    /**
     * This method returns the name of the customer when it is called
     * @return name of the customer a s string
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method adds a dish to the order arraylist
     * @param dish an object argument which contains the dish name and dish price
     */
    public void addToOrder(Dish dish)
    {
        order.add(dish);
    }

    /**
     * This method converts the order as a string which includes dish name with it's price
     * @return a string of the order
     */
    public String getOrderDescription()
    {
        if (order.isEmpty())
        {
            return "";
        }
        String outputString = order.get(0).toString();
        for (int i = 1; i < order.size(); i++)
        {
            outputString += "\n" + order.get(i).toString();
        }
        return outputString;
    }

    /**
     * This method calculates the total cost of the order
     * @return a double which contains the total cost of the order
     */
    public double getOrderTotalValue()
    {
        double totalValue= 0;
        for (int i = 0; i < order.size(); i++) {
            totalValue += order.get(i).getPrice();
        }

        return totalValue;
    }

    /**
     * This method compares two objects by their name and returns boolean suggesting they are same or not
     * @param newCustomer an object to get compared by the method
     * @return a boolean which suggests if two customers are the same or not
     */
    public boolean equals(Customer newCustomer)
    {
        return getName().equals(newCustomer.getName());
    }

}
