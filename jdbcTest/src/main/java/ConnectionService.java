import java.sql.Connection;

public interface ConnectionService {
    public Connection getConnection();

    // 释放连接(可回收机制)
    public void releaseConnection(Connection connection);
}
