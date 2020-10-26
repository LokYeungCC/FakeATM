//Transfer.java
// Represents a transfer ATM transaction

public class Transfer extends Transaction
{
   private double amount; // amount to transfer
   private Keypad keypad; // reference to keypad
   private final static int CANCELED = 0; // constant for cancel option
   private int transferNumber; //the transfer account number
   
   // Transfer constructor
   public Transfer( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad)
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      
      // initialize references to keypad
      keypad = atmKeypad;
   } // end Transfer constructor

   private boolean isAccountExist(int EnterAccNumber)
   {
   BankDatabase bankDatabase = getBankDatabase();
   if(bankDatabase.checkerAccount(EnterAccNumber))
       return true;
   else
       return false;
   }
   
   public void setTransferNumber(int EnterAccNumber) {
       transferNumber = EnterAccNumber;
   }
   
   public int getTransferNumber() {
       return transferNumber;
   }
   
   // perform transaction
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase(); 
      Screen screen = getScreen();
      
      int EnterAccNumber = 0;
      boolean enterAccSuccess = false;
      boolean enterAmountSuccess = false;
      double availableBalance; // amount available for transfer
      int confirm=0;
      
      screen.displayMessage( "Hint: Enter \"0\" to the account number can cancel this transfer transaction\n");
      do{
      screen.displayMessage( "Please enter the transfer account number: ");
      EnterAccNumber = keypad.getInput();
      
      if (EnterAccNumber == 0) {
          screen.displayMessageLine( "\nCanceling transaction..." );
      return;
      }
      else if (EnterAccNumber == getAccountNumber())
      {
          screen.displayMessage( "It is your account number,you can not transfer to the same account.\n\n");
      }
      else if(isAccountExist(EnterAccNumber))
      {
        setTransferNumber(EnterAccNumber);
        enterAccSuccess = true;
      }
      else 
      {
          screen.displayMessage( "\nInvalid account number\n\n");
      }
    }while(!enterAccSuccess);
    
    do{
        screen.displayMessage( "\nPlease enter the amount to transfer: ");
        amount = keypad.getDouble();
        
        if ( amount != CANCELED )
         {
            // get available balance of account involved
            availableBalance = 
               bankDatabase.getAvailableBalance( getAccountNumber() );
      
            // check whether the user has enough money in the account 
            if ( amount <= availableBalance )
            {   
                screen.displayMessageLine("\nAre you sure to confirm this transfer? Yes(Enter 1) or No(Enter any number except 1)" );            
                confirm =  keypad.getInput();
                
                if(confirm==1)
                {
                bankDatabase.debit( this.getAccountNumber(), amount );
                bankDatabase.credit( getTransferNumber(),amount);
                
                screen.displayMessageLine("\nTransfer Successful." );
                System.out.printf("The amount of %.2fHKD has been transferred to the account %d\n",amount,transferNumber);
                enterAmountSuccess = true;
                }
                else 
                {
                screen.displayMessageLine( "\nCanceling transaction..." );
                return;
                }
            } // end if
            else // not enough money available in user's account
            {
               screen.displayMessageLine( 
                  "\nInsufficient funds in your account." +
                  "\nPlease choose a smaller amount." );
            } // end else
         } // end if
         else // user chose cancel menu option 
         {
            screen.displayMessageLine( "\nCanceling transaction..." );
            return; // return to main menu because user canceled
         } // end else
        
        
    } while ( !enterAmountSuccess );   
}
} // end class transfer


