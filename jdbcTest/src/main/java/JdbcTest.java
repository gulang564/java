import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    //不同数据库连接方法有点不同，测试MySQL
    private static String driver = "com.mysql.jdbc.Driver";
    // Oracle为："oracle.jdbc.driver.OracleDriver "
// sql server为："com.microsoft.sqlserver.jdbc.SQLServerDriver"
    private static String url="jdbc:mysql://localhost:3306/ssm?useSSL=false";
// Oracle为："jdbc:oracle:thin:@localhost:1521:orcl"
// sql server为："jdbc:sqlserver://localhost:1433;database=数据库名"

    private static String username = "root";
    private static String password = "txc123";
    static Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName(driver);

                conn = DriverManager.getConnection(url, username, password);
                System.out.println("连接成功");

        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return conn;
    }
}
