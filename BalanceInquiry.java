// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction
{
   // BalanceInquiry constructor
   public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase )
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
   } // end BalanceInquiry constructor

   // performs the transaction
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance( getAccountNumber() );
      
      //get the interest rate for the account involved
      double interestRate = 
    		  bankDatabase.getInterestRate( getAccountNumber() );
      
    //get the interest for the account involved
      double interestOfYear =
    		  bankDatabase.getInterest( getAccountNumber() );
      
    //get the overdrawn limit for the account involved
      double limit = 
    		  bankDatabase.getLimit(getAccountNumber());
      
      // display the balance information on the screen
      screen.displayMessageLine( "\nBalance Information:" );
      screen.displayMessage( " - Available balance:             " ); 
      screen.displayDollarAmount( availableBalance );
      screen.displayMessage( "\n - Total balance:                 " );
      screen.displayDollarAmount( totalBalance );
      screen.displayMessage( "\n - Interest Rate:                 " );
      screen.displayPersentage( interestRate );
      screen.displayMessage( "\n - Interest of this year:         " );
      screen.displayDollarAmount( interestOfYear );
      screen.displayMessage( "\n - Remaining Overdrawn limit:     " );
      screen.displayDollarAmount( limit );
      screen.displayMessageLine( "" );
      
   } // end method execute
} // end class BalanceInquiry
