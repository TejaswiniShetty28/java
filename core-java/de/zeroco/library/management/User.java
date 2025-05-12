package de.zeroco.library.management;

/**
 * The User class represents an individual user of the library.
 * It stores user-specific information, including a unique user ID, username, 
 * 
 * Attributes:
 * - userId: Unique identifier for the user.
 * - username: Name of the user.
 *
 * Methods:
 * - setUserId() - To set user Id.
 * - getUserId() - It returns get User Id.
 * - setUserName() - To user name.
 * - getUserNmae() - Get user name.
 */
public class User {

	private int userId;
	private String userName;
	private Book[] borrowedBooks;

	public User(int userId, String userName, Book[] borrowedBooks) {
		this.userId = userId;
		this.userName = userName;
		this.borrowedBooks = borrowedBooks;
	}

	/**
	 * This a method to set User Id of user.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param userId
	 * @return userId
	 * @reviewed
	 */
	public int setUserId(int userId) {
		return this.userId = userId;
	}

	/**
	 * This is a method to get userId of user.
	 * 
	 * @author Tejaswini.S
	 * @return userId
	 * @reviewed
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * This is a method to set user name.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param userName
	 * @return userNmae
	 * @reviewed
	 */
	public String setUserName(String userName) {
		return this.userName = userName;
	}

	/**
	 * This is a method to get name of user.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return id
	 * @reviewed
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * This is a method shows borrowed books of user.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return String
	 * @reviewed
	 */
	public String showBorrowedBooks() {
		String res = "";
		for (int i = 0; i < borrowedBooks.length; i++) {
			res += borrowedBooks[i];
		}
		return res;	
	}
	
}

