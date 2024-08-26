import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements DatabaseConnection {
    private final String url, user, password;
    private Connection connection;

    public PostgreSQL(String url, String user,String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;

    }

    @Override
    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) 
        {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    @Override
    public void disconnect() throws SQLException {
        if (connection!= null &&!connection.isClosed())
        {
            connection.close();
        }
    }

    @Override
    public boolean isConnected() throws SQLException {
        return connection!= null &&!connection.isClosed();
    }

}
