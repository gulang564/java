import java.sql.Connection;
import java.sql.SQLException;

public class Pool_manager {
    private static DbBean dbBean = new DbBean();

    private static JdbcPool connectionPool;

    static {
        try {
            connectionPool = new JdbcPool(dbBean);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接(重复利用机制)
    public static Connection getConnection() {
        return connectionPool.getConnection();
    }

    // 释放连接(可回收机制)
    public static void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }
}
