package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    private final int connectionsLimit;
    private final LinkedHashMap<String, Connection> connectionPool;

    public ConnectionPool(int size) {
        this.connectionsLimit = size;
        this.connectionPool = new LinkedHashMap<String, Connection>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldest) {
                return size() > connectionsLimit;
            }
        };
    }

    public void addConnection(Connection connection) {
        String connectionId = connection.connectionId();
        if (connectionPool.containsKey(connectionId)) {
            throw new IllegalStateException();
        }
        connectionPool.put(connectionId, connection);
    }

    public Connection getConnection(String connectionId) {
        Connection connection = connectionPool.get(connectionId);
        if (connection == null) {
            throw new NoSuchElementException();
        }
        return connection;
    }
}
