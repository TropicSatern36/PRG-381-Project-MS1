import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CRUD {
    private DatabaseConnection connection;

    CRUD(DatabaseConnection connection)
    {
        this.connection = connection;
    }

    public void insert(User user)
    {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.UserName);
            pstmt.setString(2, user.UserSurname);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Books book)
    {
        String sql = "INSERT INTO books (title, author, publication_year) VALUES (?,?,?)";

        try (Connection conn = connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.Book);
            pstmt.setString(2, book.Author);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//-
}
