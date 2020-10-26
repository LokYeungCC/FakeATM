public class SavingAccount extends Account {
	
	private double interestRate = 0.001;
	//private String count[] = {"Yearly", "Quarterly", "Monthly"};
	double interest;
	
	public SavingAccount(int num, int pin, double avail, double total)		//Just the constructor by using the superclass's one
	{
		super(num, pin, avail, total);
	}
	
	public void setInterestRate(double rate)		//use to set the interest rate, although it is not possible to do in ATM
	{
		interestRate = rate;
	}
	
	public double getInterestRate()
	{
		return interestRate;
	}
	
	public double calInterest(double total)		//use to calculate the interest of total amount and return the result
	{
		interest = total * interestRate;
		
		return interest;
	}
	
	public int getSavingAccountNumber()		//return account number, same with the Account's one
	   {
	      return super.getAccountNumber();  
	   }
}
