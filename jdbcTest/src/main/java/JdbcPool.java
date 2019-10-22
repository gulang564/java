

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JdbcPool implements  ConnectionService {
    private List<java.sql.Connection> freeConnection =new LinkedList<java.sql.Connection>();
    private  List<Connection> activeConnection=new LinkedList<Connection>();
    private  DbBean dbBean;
    private int countConne=0;

    public  JdbcPool(DbBean dbBean) throws SQLException, ClassNotFoundException {
        this.dbBean=dbBean;
        init();
    }

    //初始化连接池
    private void init() throws SQLException, ClassNotFoundException {
        if(dbBean==null){
            return;
        }
        for (int i = 0; i <dbBean.getInitConnections() ; i++) {
           Connection newConnection=newConnection();
            if(newConnection!=null){
                freeConnection.add(newConnection);
            }

        }
    }
    private synchronized Connection newConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbBean.getDriverName());
       Connection connection=  DriverManager.getConnection(dbBean.getUrl(),dbBean.getUserName(),dbBean.getPassword());
        countConne++;
        return connection;

    }
    @Override
    public Connection getConnection() {
        try {
            Connection connection = null;

            if (countConne < dbBean.getMaxActiveConnections()) {
                // 小于最大活动连接数
                // 1.判断空闲线程是否有数据
                if (freeConnection.size() > 0) {
                    // 空闲线程有存在连接
                    // ==freeConnection.get(0);freeConnection.remove(0)
                    // 拿到在删除
                    connection =  freeConnection.remove(0);
                } else {
                    // 创建新的连接
                    connection = newConnection();
                }
                // 判断连接是否可用
                boolean available = isAvailable(connection);
                if (available) {
                    // 存放在活动线程池
                    activeConnection.add(connection);
                    countConne++;
                } else {
                    countConne--;
                    connection = getConnection();// 怎么使用重试？ 递归算法
                }

            } else {
                // 大于最大活动连接数，进行等待
                wait(dbBean.getConnTimeOut());
                // 重试
                connection = getConnection();
            }
            return connection;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public void releaseConnection(Connection connection) {
        try {
            // 1.判断连接是否可用
            if (isAvailable(connection)) {
                // 2.判断空闲线程是否已满
                if (freeConnection.size() < dbBean.getMaxConnections()) {
                    // 空闲线程没有满
                    freeConnection.add(connection);// 回收连接
                } else {
                    // 空闲线程已经满
                    connection.close();
                }
                activeConnection.remove(connection);
                countConne--;
                //多线程的时候使用
                notifyAll();
            }
        } catch (Exception e) {

        }

    }

    // 判断连接是否可用
    private boolean isAvailable(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (Exception e) {

        }
        return true;
    }
}
