package de.zeroco.banking.management;

import de.zeroco.main.Utility;

/**
 * The Transaction class provides methods for performing core banking operations such as withdrawing money, depositing funds, and transferring money between accounts. It handles
 * transactions for both savings and current accounts, ensuring that the necessary checks are made for each account type (such as balance verification and interest application).
 *  
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen,
 */	
public class Transaction {
	
	/**
     * Withdraws a specified amount of money from the given account.  For a savings account, it deducts the amount from the balance and applies interest.
     * for current account, it deducts the amount from the current balance.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @param money
	 * @param account
	 * @param accountType
	 * @return the updated balance after the withdrawal, or 0.0 if the withdrawal is not permitted.
	 * @reviewed by Praveen,
	 */		 
	public double withdraw(int money, Account account) {
		if (areAnyBlank(money, account)) return 0;
		if (account.getBalance() <= money) return account.getBalance();
		double balance = account.getBalance() - money;
		account.setBalance(balance);
		if ("savingsaccount".equalsIgnoreCase(account.getAccountType())) {
			Interest interest = new Interest();
			interest.addInterest(account);
		}
		return balance;
	}
     
    /**
     * Deposits a specified amount of money into the given account
 	 * 
 	 * @author Tejaswini.S
 	 * @since 15-01-2025
 	 * @param money
 	 * @param account
 	 * @param accountType
 	 * @return the updated balance after the deposit.
 	 * @reviewed by Praveen,
 	 */	     
	public double deposit(int money, Account account) {
		if (areAnyBlank(money, account)) return 0;
		double balance = account.getBalance() + money;
		account.setBalance(balance);
		if ("savingsaccount".equalsIgnoreCase(account.getAccountType())) {
			new Interest().addInterest(account);
			return account.getBalance();
		}
		return balance;
	}
     
    /**
     * Transfers a specified amount of money from a source account to a target account.
  	 * 
  	 * @author Tejaswini.S
  	 * @since 15-01-2025
  	 * @param money
  	 * @param sourceAccount
  	 * @param targetAccount
  	 * @return true if the transfer is successful, false if the source account does not have sufficient balance.
  	 * @reviewed by Praveen,
  	 */	  
	public boolean isTransfer(int money, Account sourceAccount, Account targetAccount) {
	    if (areAnyBlank(money, sourceAccount, targetAccount)) return false;
	    if (sourceAccount.getBalance() >= money) {
	        withdraw(money, sourceAccount);
	        deposit(money, targetAccount);            
	        return true;
	    } else {
	        return false;  
	    }
	}
	
	/**
     * Checks if any of the provided arguments are blank.
  	 * 
  	 * @author Tejaswini.S
  	 * @since 15-01-2025
  	 * @param args
  	 * @return true if any argument is blank, false otherwise..
  	 * @reviewed by Praveen,
  	 */	
	public boolean areAnyBlank(Object... args) {
	    for (Object arg : args) {
	        if (Utility.isBlank(arg)) {
	            return true;
	        }
	    }
	    return false;
	}

     public static void main(String[] args) {
    	 Account account = new  Account("Tejaswini", 200.0, "savingsaccount");
    	 Account account2 = new Account("Roopa", 200.0, "savingsaccount");
    	 Account account3 = new Account("Teju", 200.0, "savingsaccount");
    	 Account account4 = new Account("Saraswathi", 200.0, "savingsaccount");
    	 Transaction transaction = new Transaction();
    	 
    	 System.out.println(transaction.deposit(200, account));
    	 System.out.println(transaction.deposit(200, account3));
    	 
    	 System.out.println(transaction.withdraw(200, account3));
    	 
    	 System.out.println(transaction.isTransfer(200, account2, account3));
    	 
    	 System.out.println(account.viewDetails("savingsaccount"));
    	 System.out.println(account3.viewDetails("savingsaccount"));
    	 System.out.println(account3.viewDetails("currentaccount"));
    	 
    	 System.out.println(account.viewDetails("savingsaccount"));
    	 
    	 System.out.println(transaction.deposit(200, account4));
     }
     
}