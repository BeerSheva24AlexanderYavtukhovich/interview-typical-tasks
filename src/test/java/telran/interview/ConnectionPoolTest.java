package telran.interview;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {

    private ConnectionPool connectionPool;

    @BeforeEach
    public void setUp() {
        connectionPool = new ConnectionPool(3);
    }

    private void addConnections(int from, int to) {
        for (int i = from; i <= to; i++) {
            connectionPool.addConnection(new Connection(String.valueOf(i)));
        }
    }

    private void assertConnectionsExist(int from, int to, boolean shouldExist) {
        for (int i = from; i <= to; i++) {
            String connectionId = String.valueOf(i);
            if (shouldExist) {
                assertNotNull(connectionPool.getConnection(connectionId));
            } else {
                assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection(connectionId));
            }
        }
    }

    @Test
    public void testAddAndGetConnection() {
        addConnections(1, 2);
        assertConnectionsExist(1, 2, true);
    }

    @Test
    public void testAddDuplicateConnectionThrowsException() {
        connectionPool.addConnection(new Connection("1"));
        assertThrows(IllegalStateException.class, () -> connectionPool.addConnection(new Connection("1")));
    }

    @Test
    public void testGetNonExistentConnectionThrowsException() {
        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("9999"));
    }

    @Test
    public void testExceedingConnectionLimitRemovesOldest() {
        addConnections(1, 3);
        connectionPool.addConnection(new Connection("4"));
        assertConnectionsExist(1, 1, false);
        assertConnectionsExist(2, 4, true);
    }

    @Test
    public void testExceedingLimitWithFrequentAccess() {
        addConnections(1, 3);
        connectionPool.getConnection("1");
        connectionPool.getConnection("1");
        connectionPool.addConnection(new Connection("4"));
        assertConnectionsExist(1, 1, true);
        assertConnectionsExist(2, 2, false);
        assertConnectionsExist(3, 4, true);
    }

    @Test
    public void testRemovingMultipleConnections() {
        addConnections(1, 3);
        connectionPool.addConnection(new Connection("4"));
        connectionPool.addConnection(new Connection("5"));
        assertConnectionsExist(1, 2, false);
        assertConnectionsExist(3, 5, true);
    }

    @Test
    public void testEdgeCaseConnectionLimitOne() {
        connectionPool = new ConnectionPool(1);
        connectionPool.addConnection(new Connection("1"));
        assertConnectionsExist(1, 1, true);
        connectionPool.addConnection(new Connection("2"));
        assertConnectionsExist(1, 1, false);
        assertConnectionsExist(2, 2, true);
    }

    @Test
    public void testEmptyPoolThrowsException() {
        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("1"));
    }
}
