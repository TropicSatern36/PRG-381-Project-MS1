import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaDB implements DatabaseConnection {
    private final String url;
    private Connection connection;

    public JavaDB(String url)
    {
        this.url = url;
    }

    @Override
    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed())
        {
            connection = DriverManager.getConnection(url);
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
