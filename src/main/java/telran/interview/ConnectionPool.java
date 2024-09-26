package telran.interview;

public class ConnectionPool {
    // TODO work out data structure
    // Connection pool comprises of some number of connection
    // it cannot contains more than the predifined number of connections
    // policy of removing connection - if number of connections is going to exceed
    // limit a connection should be removed from connection pool
    // Policy should be in consideration the order odf adding connections in pool
    // and using connections

    public ConnectionPool(int size) {
        // TODO constructor;
    }

    public void addConnection(Connection connection) {
        // TODO
        // exception should be thrown if connection already exist IllegalStateException
    }

    public Connection getConnection(String connectionId) {
        // TODO
        // If connection with a given ID does not exist the NoSuchElementException
        // should be thrown
        return null;
    }

}
