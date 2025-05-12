package de.zeroco.library.management;

/**
 * The Library class represents a collection of books and list of users registered
 * in library. 
 * 
 * Attributes:
 * - availableBooks: List of books available in library.
 * - users: Users registered in library.
 * - borrowedBooks: Books borrowed by user.
 * 
 * Methods:
 * -setBorrowedBooks: to set books borrowed.
 * -getBorrowedBooks: to get books borrowed.
 * -setAvailableBooks: to set available books.
 * -getAvailableBooks: to get available books.
 * -setUsers: to set users.
 * -getUsers: to get users.
 * -addBooks: adds new book to library.
 * -addUsers: add new user to library.
 * -printAvailableBooks:print all the books available in library.
 * -printBorrowedBooks: print all borrowed by user.
 * -UpdateOnAvailableBook: updates available books if any book taken by user or if any book returned by user
 * -returnBook: if any user returns book and update the available book list
 * -borrowBooks: add book to the user if any taken by the user and update the list
 * -returnedBooksCount : count of all books returned
 * -booksBorrowedCount : count of all books borowed.
 */
public class Library {
	
	private Book[] availableBooks;
	private User[] users;
	private Book[] borrowedBooks;
	private int returnBookCount = 0;

	public Library(Book[] availableBooks, User[] users, Book[] borrowedBooks) {
		this.availableBooks = availableBooks;
		this.users = users;
		this.borrowedBooks = borrowedBooks;
	}
	
	/**
	 * This method sets the array of borrowed books.
	 * 
	 * @since 9-01-2025
	 * @author Tejaswini
	 * @param borrowBooks 
	 * @return returns The updated array of borrowed books.
	 * @reviwed 
	 */
	public Book[] setBorrowBooks(Book[] borrowBooks) {
		return this.borrowedBooks = borrowBooks;
	}
	
	/**
	 * This method gets the array of borrowed books.
	 * 
	 * @since 9-01-2025
	 * @author Tejaswini
	 * @param borrowBooks
	 * @return returns the updated array of borrowed books.
	 * @reviwed 
	 */
	public Book[] getBorrowBooks() {
		return borrowedBooks;
	}
	 
	
	/**
     * This is a method which set the available books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param availableBooks
	 * @return books array
	 * @reviewed 
	 */
	public Book[] setAvailableBooks(Book[] availableBooks) {
		return this.availableBooks = availableBooks;
	}
	
	/**
     * This is a method which get the available books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return books array
	 * @reviewed 
	 */
	public Book[] getAvailableBooks() {
		return availableBooks;
	}
	
	/**
     * This is a method which set the users.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param users
	 * @return users array
	 * @reviewed 
	 */
	public User[] setUsers(User[] users) {
		return this.users = users;
	}
	
	/**
     * This is a method which get the users.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return users array
	 * @reviewed 
	 */
	public User[] getUsers() {
		return users;
	}
	
	/**
     * This is a method which adds books to the library.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param Book
	 * @return books array
	 * @reviewed 
	 */
	public Book[] addBook(Book book) {
		Book[] newBooks = new Book[availableBooks.length + 1];
		for (int i = 0; i < availableBooks.length; i++) {
			newBooks[i] = availableBooks[i];
		}
		newBooks[availableBooks.length] = book;
		return availableBooks = newBooks;
	}
	
	/**
     * This is a method which adds users to the users array.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param users
	 * @return users array
	 * @reviewed 
	 */
	public User[] addUser(User user) {
		User[] newUsers = new User[users.length + 1];
		for (int i = 0; i < users.length; i++) {
			newUsers[i] = users[i];
		}
		newUsers[users.length] = user;
		return users = newUsers;
	}
	

	/**
     * This is a method which prints available books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return string of available books
	 * @reviewed 
	 */
	public String printAvailableBooks() {
		String res = "";
        for (int i = 0; i < availableBooks.length; i++) {
            res += availableBooks[i].toString() + "\n";
        }
        return res;
    }
	
	/**
     * This is a method which prints borrowed books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return array of borrowed books
	 * @reviewed 
	 */
	public String printBorrowedBooks() {
		String res = "";
        for(int i = 0; i < borrowedBooks.length; i++) {
        	res += borrowedBooks[i].toString() + "\n";	
        }
        return res;
	}
	
	/**
     * This is a method which updates the books in library after book returned from the user or taken by the user.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param book
	 * @return array of borrowed books
	 * @reviewed 
	 */
	public void updateAvailableBooks(Book book) {
	    Book[] newAvailableBooks = new Book[availableBooks.length + (book.isAvailable() ? 1 : -1)];
	    int index = 0;
	    if (book.isAvailable()) {
	        for (int i = 0; i < availableBooks.length; i++) {
	            newAvailableBooks[index++] = availableBooks[i];
	        }
	        newAvailableBooks[index] = book;
	    } else {
	        for (int i = 0; i < availableBooks.length; i++) {
	            if (availableBooks[i] != book) {
	                newAvailableBooks[index++] = availableBooks[i];
	            }
	        }
	    }
	    availableBooks = newAvailableBooks;
	}
	
	/**
	 * This is a method adds book to the user array and remove the book from
	 * available book array.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param book
	 * @param library
	 * @reviewed
	 */
	public void borrowBook(Book book) {
		if (!book.isAvailable())
			return;
		Book[] newBorrowedBooks = new Book[borrowedBooks.length + 1];
		for (int i = 0; i < borrowedBooks.length; i++) {
			newBorrowedBooks[i] = borrowedBooks[i];
		}
		newBorrowedBooks[borrowedBooks.length] = book;
		book.setAvailable(false);
		updateAvailableBooks(book);
		borrowedBooks = newBorrowedBooks;
	}

	/**
	 * This is a method delete returned book from user array and add the same book
	 * to the available books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param book
	 * @param library
	 * @reviewed
	 */
	public void returnBook(Book book) {
		int index = 0;
		Book[] newBorrowedBooks = new Book[borrowedBooks.length - 1];
		for (int i = 0; i < borrowedBooks.length; i++) {
			if (borrowedBooks[i] == book) {
				book.setAvailable(true);
				returnBookCount++;
				continue;
			}
			if (index < newBorrowedBooks.length) {
				newBorrowedBooks[index] = borrowedBooks[i];
				index++;
			}
		}
	    updateAvailableBooks(book);
		borrowedBooks = newBorrowedBooks;
	}
	
	/**
	 * This is a method which counts returned books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return int
	 * @reviewed
	 */
	public int returnBooksCount() {
		return returnBookCount;	
	}
	
	/**
	 * This is a method which counts borrowed books.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return int
	 * @reviewed
	 */
	public int borrowedBooksCount() {
		return borrowedBooks.length;
	}


//	public static void main(String[] args) {
//		Book bookOne = new Book("10985", "The Mysterious Cave", "Chethan Bhagath");
//		Book bookTwo = new Book("10986", "Wings of Fire", "Kalam");
//		Book bookThree = new Book("10987", "Malgudi Days", "R.K");
//		Book bookFour = new Book("10988", "The Inheritance of Loss", "Kiran Desai");
//		Book bookFive = new Book("10989", "A Suitable Boy", "Vikram Seth");
//		Book[] allBooks = { bookOne, bookTwo, bookThree, bookFour, bookFive};
//		Book[] borrowedBooks = new Book[0];
//		Book[] firstUser = {};
//		Book[] secondUser = {};
//		Book[] thirdUser = {};
//		User userOne = new User(1, "Tejaswini", firstUser);
//		User userTwo = new User(2, "Roopa", secondUser);
//		User userThree = new User(3, "Sai", thirdUser);
//		User[] allUsers = { userOne, userTwo, userThree};
//		Library library = new Library(allBooks, allUsers, borrowedBooks);
//		library.borrowBook(bookOne);
//		System.out.println("After User One borrows a book:");
//		System.out.println(library.printAvailableBooks());
//		System.out.println(library.printBorrowedBooks());
//		library.returnBook(bookOne);
//		System.out.println("After User One returns the book:");
//		System.out.println(library.printAvailableBooks());
//		System.out.println(library.printBorrowedBooks());
//	}
	
}

	

