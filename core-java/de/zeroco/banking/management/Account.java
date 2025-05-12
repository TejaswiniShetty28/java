package de.zeroco.banking.management;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a bank account with details such as customer name, account type, balance, and account ID. This class allows operations such as creating an account, 
 * viewing account details, setting and getting balances, and handling account types for both savings and current accounts.
 * 
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen,
 */	
public class Account {
	
	private static AtomicInteger accountIdGenerator = new AtomicInteger(1000);
	private String customerName;
	private double balance;
	private int accountId;
	private String accountType;
	
	public Account(String customerName, double balance, String accountType) {
        this.accountId = accountIdGenerator.incrementAndGet();
        this.customerName = customerName;
        this.balance = balance;
        this.accountType = accountType; 
    }
	
	/**
     * This is a method which  creates account.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return string of accoundId and customer name.
	 * @reviewed by Praveen,
	 */	
	public String createAccount(String accountType) {
	    if ("savingsaccount".equalsIgnoreCase(getAccountType()) || "currentsavings".equalsIgnoreCase(getAccountType())) {
	        return "Account successfully created with ID: " + accountId + " for " + customerName;
	    }
	    return new String();
	}
	
	/**
     * This is a method which displays account details.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return string of accoundId, customer name, account type and balance.
	 * @reviewed by Praveen,
	 */	
	public String viewDetails(String accountType) {
	    if ("savingsaccount".equalsIgnoreCase(accountType) || "currentaccoount".equalsIgnoreCase(accountType)) 
	        return customerName + " " + accountId + " " + accountType + " " + balance;
	    return new String();
	}

	/**
     * This method set customer name.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @param customerName
	 * @return string of customer name.
	 * @reviewed by Praveen,
	 */	
	public String setCustomerName(String customerName) {
		return this.customerName = customerName;
	}
	
	/**
     * This method get customer name.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return string of customer name.
	 * @reviewed by Praveen,
	 */
	public String getCustomerName() {
		return customerName;		
	}
	
	/**
     * This method set balance of account.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @param balance
	 * @return balance which is double.
	 * @reviewed by Praveen,
	 */	
	public double setBalance(double balance) {
		return this.balance = balance;
	}
	
	/**
     * This method get balance of account.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return balance which is double.
	 * @reviewed by Praveen,
	 */	
	public double getBalance() {
		return balance;
	}
	
	/**
     * This method set account ID.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @param accountId
	 * @return accountId which is int.
	 * @reviewed by Praveen,
	 */	
	public int setAccountId(int accountId) {
		return this.accountId = accountId;
	} 

	/**
     * This method get account ID.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return accountId which is int.
	 * @reviewed 
	 */	
	public int getAccountId() {
		return accountId;
	}
	
	/**
     * This method set account type either savings account or current account.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @param accountType
	 * @return account type which is String.
	 * @reviewed by Praveen,
	 */	
	public String setAccountType(String accountType) {
		if (accountType != "")
		return this.accountType = accountType;
		return new String();
	}
	
	/**
     * This method get account type either savings account or current account.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return account type which is String.
	 * @reviewed by Praveen,
	 */	
	public String getAccountType() {
		return accountType;
	}
	
}
