import java.util.Date; // Import the Date class from java.util package

public class Books {
    // Declare public variables for the book's details
    public String Book; // The name of the book
    public String Author; // The author of the book
    public Date DateRented; // The date when the book was rented
    public Double Price; // The price of the book

    // Constructor to initialize a new Books object
    public Books(String book, Date date, String author, Double price) {
        this.Book = book; // Set the book's name
        this.DateRented = date; // Set the date when the book was rented
        this.Author = author; // Set the author of the book
        this.Price = price; // Set the price of the book
    }
}
