/**
 * CSCI 1110 – Assignment 02
 * @author Bhavya G.
 * Bhavya Ghevariya – B00872733
 * This is a class of Table which creates an objetc Table and manipulates it with methods
 */

import java.util.ArrayList;


public class Table {

    //Declaration of the variables - 1 Arraylist, 2 integers
    private ArrayList<Customer> seatedCustomer = new ArrayList<>();
    private int size;
    private int tableNumber;
    public double bill;

    /**
     * This is a constructor which creates a table object
     * @param size an int containing the number of people that can sit on the table
     * @param tableNumber an int containing the table number
     */
    public Table(int size, int tableNumber)
    {
        this.size = size;
        this.tableNumber = tableNumber;
    }

    /**
     * This method assigns a seat to the customer returns true if the seat has been assigned
     * If a customer already has a table then it will return true
     * @param newCustomer a customer object which needs to be assign a seat
     * @return a boolean suggesting that the seat has been assigned or not
     */
    public boolean seatCustomer(Customer newCustomer)
    {
        if(seatedCustomer.size() >= size)
        {
            return false;
        }
        for (int i = 0; i < seatedCustomer.size(); i++)
        {
            if (seatedCustomer.get(i).getName().equals(newCustomer.getName()))
            {
                return false;
            }
        }
        seatedCustomer.add(newCustomer);
        return true;
    }

    /**
     * This method assigns seats to the group of customers and returns true if the seats have been assigned
     * If the table is already full or there are not enough space the method will return false
     * @param newCustomers an arraylist of customer objects which will be assigned seats
     * @return a boolean suggesting that the seats have been assigned or not
     */
    public boolean seatCustomer(ArrayList<Customer> newCustomers)
    {
        if (newCustomers.size() < seatedCustomer.size())
        {
            return false;
        }
        for (int i = 0; i < newCustomers.size(); i++)
        {
            seatCustomer(newCustomers.get(i));
        }
        return true;
    }

    /**
     * This method finds a customer from the customers by their name
     * @param name a string suggesting the name of the customer
     * @return Customer an object if the string is in the customer list, otherwise it will return null
     */
    public Customer findCustomerByName(String name)
    {
        for (int i = 0; i < seatedCustomer.size(); i++)
        {
            if (seatedCustomer.get(i).getName().equals(name))
            {
                return seatedCustomer.get(i);
            }
        }
        return null;
    }

    /**
     * This method generates a bill containing the order description
     * If the boolean parameter is true it will create a split bill
     * If the boolean parameter is false then it will create an individual bill
     * @param billNeeded a boolean suggesting that the method will create a split bill or an individual bill
     * @return a string returned from other method
     */
    public String generateBill(boolean billNeeded)
    {
        if (billNeeded)
        {
            return createSplitBill();
        }
        else
        {
            return createIndividualizedBill();
        }
    }

    /**
     * This method creates a split bill and returns it as a string
     * @return a string which contains the bill with, table no, order description, total bill amount and split amount
     */
    public String createSplitBill()
    {
        String outputString = "";
        double finalBill = 0;

        outputString += "Table: " + tableNumber + "\n";
        for (int i = 0; i < seatedCustomer.size(); i++) {
            if (seatedCustomer.get(i).getOrderDescription().equals(""))
            {
                continue;
            }
            outputString += seatedCustomer.get(i).getOrderDescription() + "\n";
            finalBill += seatedCustomer.get(i).getOrderTotalValue();
        }
        outputString += "Total: " + String.format("%.2f", finalBill) + "\n" + "Split: " + String.format("%.2f", (finalBill/ seatedCustomer.size()));
        return outputString;
    }

    /**
     * This method creates an individual bill and returns it as a string
     * @return a string which contains the bill with table no, order description nby customers and total bill amount
     */
    public String createIndividualizedBill()
    {
        String outputString = "";
        for (int i = 0; i < seatedCustomer.size(); i++)
        {
            outputString += "Table: " + tableNumber + "\n";
            outputString += "Customer " + seatedCustomer.get(i).getName() + "\n";
            if (seatedCustomer.get(i).getOrderDescription().equals(""))
            {
                outputString +=  "Total: " + String.format("%.2f",seatedCustomer.get(i).getOrderTotalValue()) + "\n";
                continue;
            }
            outputString += seatedCustomer.get(i).getOrderDescription() + "\n" +
                    "Total: " + String.format("%.2f",seatedCustomer.get(i).getOrderTotalValue()) + "\n";
        }
        return outputString;
    }


}
