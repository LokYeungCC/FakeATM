
public class CurrentAccount extends Account {
	
	private double overdrawnLimit = 10000;
	
	public CurrentAccount(int num, int pin, double avail, double total)		//Just the constructor by using the superclass's one
	{
		super(num, pin, avail, total);
	}
	
	public void setInterestRate(double limit)
	{
		overdrawnLimit = limit;
	}
	
	public double getOverdrawnLimit()	//return the remaining overdrawn limit
	{
		return overdrawnLimit;
	}
	
	public int getCurrentAccountNumber()	//return account number, same with the Account's one
	   {
	      return super.getAccountNumber();  
	   }
	
	public void debitLimit( double amount )		//subtract from Overdrawn Limit balance
	   {
	      
			overdrawnLimit -= amount; 
	   }
}
