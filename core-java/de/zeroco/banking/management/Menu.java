package de.zeroco.banking.management;


/**
 * The Menu class manages the user interface for interacting with the banking system. It displays a menu of available operations, handles user input, and invokes the
 * corresponding methods for account management and transaction handling.
 * 
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen,
 */
public class Menu {
	
	/**
     *Generates and returns a string representing the menu options available to the user in the banking system.
     * This method provides a list of operations that the user can select from, such as creating an account,
     * depositing money, withdrawing money, and more. It is used to present the user interface options.
	 * 
	 * @author Tejaswini.S
	 * @since 15-01-2025
	 * @return string of create account, deposit money, withdraw money, transfer money, view account details, logtransaction, exit.
	 * @reviewed by Praveen,
	 */	
	public String getMenuOptions() {
	    return "Please select an option:\n" + "1. Create Account\n" + "2. Deposit Money\n" + "3. Withdraw Money\n" + "4. Transfer Money\n" + "5. View Account Details\n" + "6. Log Transactions\n" + "7. Exit\n";
	}
	
	/**
     *Displays and handles a menu of operations for managing accounts and transactions.
 	 * 
 	 * @author Tejaswini.S
 	 * @since 15-01-2025
 	 * @param transaction
 	 * @param sourceAccount
 	 * @param targetAccount
 	 * @param money
 	 * @param transactionLog
 	 * @param money
 	 * @param exit
 	 * @param choice
 	 * @param input
 	 * @param account type
 	 * @return void
 	 * @reviewed by Praveen,
 	 */	
	  public void menu(Account sourceAccount, Account targetAccount, Transaction transaction, TransactionLog transactionLog, int money, Exit exit, int choice, String accountType, String input) {
	          switch(choice) {
	              case 1:
	                  sourceAccount.createAccount(accountType);
	                  break;
	              case 2:
	                  transaction.deposit(money, sourceAccount);
	                  break;
	              case 3:
	                  transaction.withdraw(money, sourceAccount);
	                  break;
	              case 4:
	                  transaction.isTransfer(money, sourceAccount, targetAccount);
	                  break;
	              case 5:
	                  sourceAccount.viewDetails(accountType);
	                  break;
	              case 6:
	                  transactionLog.logTransaction(transaction, sourceAccount, targetAccount, money);
	                  break;
	              case 7:
	                  exit.exitSystem(input);
	                  break;
	              default:
	            	  new String();
	                  break;
	            }
	    }
	  
	  public void menu(Account sourceAccount, int money, int choice, Transaction transaction) {
		  menu(sourceAccount, null, transaction, null, money, null, choice, null, null);
	  }
	  
	  public void menu(Account sourceAccount, String accountType, int choice) {
		  menu(sourceAccount, null, null, null, 0, null, choice, accountType, null);
	  }
	  
	  public void menu(int money, Account sourceAccount, Account targetAccount, int choice, Transaction transaction) {
		  menu(sourceAccount, targetAccount, transaction, null, money, null, choice, null, null);
	  }
	  
	  public void menu(Account sourceAccount, Transaction transaction, int money, int choice) {
		  menu(sourceAccount, null, transaction, null, money, null, choice, null, null);
	  }
	  
	  public void menu(String input, Exit exit, int choice) {
		  menu(null, null, null, null, 0, exit, choice, null, input);
	  }
	  
	  public static void main(String[] args) {
	        Account account = new Account("Tejaswini", 200.0, "savingsaccount");
//	        Account accountOne = new Account("Roopa", 0.0, "currentaccount");
	        Transaction transaction = new Transaction();
//	        TransactionLog transactionLog = new TransactionLog();
	        Menu menu = new Menu();
//	        Exit exit = new Exit();

	        int choice = 2; 

	        System.out.println(menu.getMenuOptions());

	        menu.menu(account, 200, choice, transaction);
	        
	        if (choice == 7) {
	            return;
	        }
	    }
}


