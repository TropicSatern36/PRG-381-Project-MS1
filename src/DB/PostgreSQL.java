import java.sql.Connection; // Import the Connection interface for handling database connections
import java.sql.DriverManager; // Import DriverManager for establishing database connections
import java.sql.SQLException; // Import SQLException for handling SQL exceptions

/**
 * Implementation of the DatabaseConnection interface for PostgreSQL databases.
 */
public class PostgreSQL implements DatabaseConnection {
    private final String url; // URL for the database connection
    private final String user; // Username for the database connection
    private final String password; // Password for the database connection
    private Connection connection; // Connection object to manage the database connection

    /**
     * Constructor to initialize PostgreSQL connection parameters.
     *
     * @param url      The database URL.
     * @param user     The username for the database.
     * @param password The password for the database.
     */
    public PostgreSQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Connects to the PostgreSQL database.
     * If the connection is not open or is closed, a new connection is established.
     *
     * @return The database connection.
     * @throws SQLException If a database access error occurs or the URL is invalid.
     */
    @Override
    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    /**
     * Disconnects from the PostgreSQL database.
     * Closes the connection if it is open.
     *
     * @throws SQLException If a database access error occurs or the connection is
     *                      invalid.
     */
    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * Checks if the connection to the PostgreSQL database is currently open.
     *
     * @return True if the connection is open; false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public boolean isConnected() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
