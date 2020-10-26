// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{
   private Account accounts[]; // array of Accounts
   private SavingAccount sAccounts[];
   private CurrentAccount cAccounts[];
   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {
      accounts = new Account[ 2 ]; // just 2 accounts for testing
      accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
      accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
      sAccounts = new SavingAccount [2];
      sAccounts[0] = new SavingAccount( 12345, 54321, 1000.0, 1200.0 );
      sAccounts[1] = new SavingAccount( 98765, 56789, 200.0, 200.0 );
      cAccounts = new CurrentAccount[2];
      cAccounts[0] = new CurrentAccount( 12345, 54321, 1000.0, 1200.0 );
      cAccounts[1] = new CurrentAccount( 98765, 56789, 200.0, 200.0 );
   } // end no-argument BankDatabase constructor
   
   // retrieve Account object containing specified account number
   private Account getAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( Account currentAccount : accounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount
   
   private SavingAccount getSavingAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( SavingAccount currentAccount : sAccounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   }
   
   private CurrentAccount getCurrentAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( CurrentAccount currentAccount : cAccounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   }

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   public void credit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).credit( amount );
   } // end method credit

   // debit an amount from of Account with specified account number
   public void debit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).debit( amount );
   } // end method debit
   
   //debit the extra amount from of CurrentAccount with specified account number
   public void debitLimit( int userAccountNumber, double amount)
   {
	   getCurrentAccount( userAccountNumber ).debitLimit( amount );
   }
   
   //return the interest rate of SavingAccount with specified account number
   public double getInterestRate( int userAccountNumber )
   {
	   return getSavingAccount( userAccountNumber ).getInterestRate();
   }
   
   //return the interest of SavingAccount with specified account number
   public double getInterest(int userAccountNumber)
   {
	   return getSavingAccount( userAccountNumber ).calInterest( getTotalBalance(userAccountNumber) );
   }
   
   //return the overdrawn limit of SavingAccount with specified account number
   public double getLimit(int userAccountNumber)
   {
	   return getCurrentAccount( userAccountNumber ).getOverdrawnLimit();
   }

   //====================insert by our team==================================
   public boolean checkerAccount( int accountNumber )
   {
      // attempt to retrieve the account with the account number
      Account transferAccount = getAccount( accountNumber );

      // if account exists, return result of Account method validatePIN
      if ( transferAccount != null )
         return true;
      else
         return false; // account number not found, so return false
   } // end method checkerAmount
} // end class BankDatabase
