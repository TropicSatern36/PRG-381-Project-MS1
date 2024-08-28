import java.util.Date; // Import the Date class for handling date values

/**
 * Represents a record of a user borrowing a book.
 */
public class UserLibrary {
    public String Name; // The email of the user who borrowed the book
    public String Book; // The name of the book borrowed
    public Date DateRented; // The date when the book was borrowed

    /**
     * Constructor to initialize a UserLibrary object with the provided details.
     *
     * @param name The email of the user who borrowed the book.
     * @param book The name of the book that was borrowed.
     * @param date The date when the book was borrowed.
     */
    public UserLibrary(String name, String book, Date date) {
        this.Name = name; // Assigns the user's email to the Name field
        this.Book = book; // Assigns the name of the borrowed book to the Book field
        this.DateRented = date; // Assigns the borrowing date to the DateRented field
    }
}
