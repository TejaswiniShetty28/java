package de.zeroco.banking.management;

import de.zeroco.main.Utility;

/**
 * The Interest class handles the application of interest to a savings account balance. It provides functionality to calculate and add daily interest based on the account balance.
 * The interest rate used is 4% per annum, applied daily.
 * 
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen,
 */	
public class Interest {
	
	/**
     *  Adds daily interest to the balance of the given account.
  	 * 
  	 * @author Tejaswini.S
  	 * @since 15-01-2025
  	 * @param account
  	 * @return the updated balance of the account after adding the interest.
  	 * @reviewed by Praveen,
  	 */	 	
	public double addInterest(Account account) {
		    if (Utility.isBlank(account)) return 0;
	        double balance = account.getBalance();         
	        if (balance > 0) {
	            double interest = balance * (0.04 / 365);
	            balance += interest; 
	            account.setBalance(balance); 
	            return account.getBalance(); 
	        }	        
	        return account.getBalance(); 
	}

	
}

