/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The number of tickets printed.
    private int ticketNumber;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
       
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public int getTicketNumber()
    {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public void insertMoney(int amount)
    {
        if (amount > 0){
            balance = balance + amount;
        }
        else{
            System.out.println("Use a positive amount: "+ amount);
        }
            
    }
    
    public Integer calculateTotal(){
        total = balance + total;
        return total;
    }
    
    public int incrementTicketNumber(){
        ticketNumber++;
        return ticketNumber;
    }
    

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        if(balance >= price){
            System.out.println("###############");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents."); 
            System.out.println("##################"); 
            System.out.println();
            
            total += price;
            balance -= price;
        } 
        else{
            int diff = price - balance;
            System.out.println("You must insert at least: " + diff + " cents.");
        }
            
            
    }
    
    public int refundBalance(){
        int amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
