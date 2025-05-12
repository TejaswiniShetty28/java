package de.zeroco.banking.management;

/**
 * The TransactionLog class is responsible for logging and validating transactions between accounts. It facilitates the transfer of money between a source account and a target account while ensuring
 * that the transaction is valid and both accounts are of acceptable types.
 * 
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen,
 */
public class TransactionLog {

	/**
     *Logs and validates a transaction by transferring a specified amount of money between a source account and a target account.
  	 * 
  	 * @author Tejaswini.S
  	 * @since 15-01-2025
  	 * @param transaction
  	 * @param sourceAccount
  	 * @param targetAccount
  	 * @param money
  	 * @return he updated balance of the target account if the transaction is successful and valid; otherwise, returns 0.0.
  	 * @reviewed by Praveen,
  	 */	
	  public double logTransaction(Transaction transaction, Account sourceAccount, Account targetAccount, int money) {
	      boolean isSuccessful = transaction.isTransfer(money, sourceAccount, targetAccount);
	       if (isSuccessful && isValidTransaction(sourceAccount, targetAccount)) {
	           return targetAccount.getBalance();
	       } else {
	           return 0.0;
	       }
	  }
	  
	  /**
	   *Validates the transaction by checking the account types of the source and target accounts.
	   * 
	   * @author Tejaswini.S
	   * @since 15-01-2025
	   * @param sourceAccount
	   * @param sourceAccount
	   * @param targetAccount
	   * @return true if both accounts are of valid types false otherwise.
	   * @reviewed by Praveen,
	   */	
	  private boolean isValidTransaction(Account sourceAccount, Account targetAccount) {
	        return (sourceAccount.getAccountType().equalsIgnoreCase("savingsaccount") || sourceAccount.getAccountType().equalsIgnoreCase("currentaccount"))  && (targetAccount.getAccountType().equalsIgnoreCase("savingsaccount") || targetAccount.getAccountType().equalsIgnoreCase("currentaccount")); 
	  }
	  
}


