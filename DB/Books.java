import java.util.Date;//+
public class Books {
    public String Book, Author;//+
    // Create a variable to store a date//+
    public Date DateRented;
    public Double Price;

    public Books(String book, Date date, String author, Double price)
    {
        this.Book = book;
        this.DateRented = date;
        this.Author = author;
        this.Price = price;
    }
}
