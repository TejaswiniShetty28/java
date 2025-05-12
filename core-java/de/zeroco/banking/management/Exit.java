package de.zeroco.banking.management;


/**
 *The Exit class is responsible for handling the user’s decision to exit or return to the menu in the banking system.
 * 
 * @author Tejaswini.S
 * @since 15-01-2025
 * @reviewed by Praveen, 
 */
public class Exit {
	
	/**
     *Prompts the user to confirm whether they want to exit the system.
  	 * 
  	 * @author Tejaswini.S
  	 * @since 15-01-2025
  	 * @param choice
  	 * @return 1 if the user wants to exit, 0 if the user wants to return to the menu, -1 if the input is invalid.
  	 * @reviewed by Praveen,
  	 */	
	public int exitSystem(String choice) {
	    if (choice.equalsIgnoreCase("y")) {
	        return 1; 
	    }
	    if (choice.equalsIgnoreCase("n")) {
	        return 0;  
	    }
	    return -1;  
	}
}
