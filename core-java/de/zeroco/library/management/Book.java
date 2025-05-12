package de.zeroco.library.management;

/**
 * The Book class represents a book in the library.
 * It contains details such as the book's ID, title, author, and availability status.
 * This class provides methods to get and set book information, and check availability.
 * 
 * Attributes:
 * - id: Unique identifier for the book.
 * - title: The title of the book.
 * - author: The author of the book.
 * - isAvailable: Indicates whether the book is available for borrowing.
 *
 * Methods:
 * - setId(): Set ID for the book.
 * - setTitle(): Set title for the book
 * - setAuthor() : Set Author for book
 * - getId(): Returns the book's ID.
 * - getTitle(): Returns the book's title.
 * - getAuthor(): Returns the book's author.
 * - isAvailable(): Checks if the book is available for borrowing.
 * - setAvailable(): Sets the availability status of the book.
 */
public class Book {
	
	private String id;
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	
	/**
     * This is a method set Id of book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param id
	 * @return id
	 * @reviewed by Praveen,
	 */
	public String setId(String id) {
		return this.id = id;
	}
	
	/**
     * This is a method get Id of book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return id
	 * @reviewed by Praveen,
	 */
	public String getId() {
		return id;
	}
	
	/**
     * This is a method set title of book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param title
	 * @return title
	 * @reviewed by Praveen,
	 */
	public String setTitle(String title) {
		return this.title = title;
	}
	
	/**
     * This is a method get title of book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return title
	 * @reviewed by Praveen,
	 */
	public String getTitle() {
		return title;
	}
	
	/**
     * This is  a method set author for book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param author
	 * @return author
	 * @reviewed by Praveen,
	 */
	public String setAuthor(String author) {
		return this.author = author;
	}
	
	/**
     * This is a method set Id of book.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return author
	 * @reviewed by Praveen,
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
     * This is a method returns true if book is availabe or return false if book is not available.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return booelan  value
	 * @reviewed by Praveen,
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
     * This is a method set boolean either true or false.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @param isAvailable
	 * @return boolean value
	 * @reviewed by Praveen,
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/**
     * This is a method which concatenates ID, title, author.
	 * 
	 * @author Tejaswini.S
	 * @since 9-01-2025
	 * @return String of all concatenated fields.
	 * @reviewed by Praveen,
	 */
	@Override
	public String toString() {
		return this.id + " " + this.title + " " + this.author;
	}
	
}