import java.sql.Connection; // Import the Connection class for handling database connections
import java.sql.DriverManager; // Import DriverManager to manage the connection to the database
import java.sql.SQLException; // Import SQLException to handle SQL-related errors

/**
 * Implements the DatabaseConnection interface to manage a database connection
 * using JDBC (Java Database Connectivity).
 */
public class JavaDB implements DatabaseConnection {
    private final String url; // The URL of the database to connect to
    private Connection connection; // The Connection object to interact with the database

    /**
     * Constructor to initialize the JavaDB object with the database URL.
     *
     * @param url The URL of the database to connect to.
     */
    public JavaDB(String url) {
        this.url = url;
    }

    /**
     * Establishes a connection to the database if not already connected.
     *
     * @return The Connection object representing the established connection.
     * @throws SQLException If a database access error occurs during connection.
     */
    @Override
    public Connection connect() throws SQLException {
        // Check if the connection is not established or is closed
        if (connection == null || connection.isClosed()) {
            // Establish a new connection using the URL
            connection = DriverManager.getConnection(url);
        }
        // Return the established connection
        return connection;
    }

    /**
     * Closes the connection to the database if it is open.
     *
     * @throws SQLException If a database access error occurs or if the connection
     *                      is already closed.
     */
    @Override
    public void disconnect() throws SQLException {
        // Check if the connection is not null and is not already closed
        if (connection != null && !connection.isClosed()) {
            // Close the connection
            connection.close();
        }
    }

    /**
     * Checks if the connection to the database is currently active.
     *
     * @return True if the connection is active; otherwise, false.
     * @throws SQLException If a database access error occurs while checking the
     *                      connection status.
     */
    @Override
    public boolean isConnected() throws SQLException {
        // Check if the connection is not null and is not closed
        return connection != null && !connection.isClosed();
    }
}
