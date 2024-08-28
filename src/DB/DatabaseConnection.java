import java.sql.Connection; // Import the Connection class from java.sql package to handle database connections
import java.sql.SQLException; // Import SQLException to handle SQL-related errors

/**
 * Interface for managing database connections.
 * Classes implementing this interface must provide implementations for
 * connecting to, disconnecting from, and checking the status of a database
 * connection.
 */
public interface DatabaseConnection {

    /**
     * Establishes a connection to the database.
     *
     * @return A Connection object representing the established connection.
     * @throws SQLException If a database access error occurs during connection.
     */
    Connection connect() throws SQLException;

    /**
     * Closes the connection to the database.
     *
     * @throws SQLException If a database access error occurs or if the connection
     *                      is already closed.
     */
    void disconnect() throws SQLException;

    /**
     * Checks if the connection to the database is currently active.
     *
     * @return True if the connection is active; otherwise, false.
     * @throws SQLException If a database access error occurs while checking the
     *                      connection status.
     */
    boolean isConnected() throws SQLException;
}
