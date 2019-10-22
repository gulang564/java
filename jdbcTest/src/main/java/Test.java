import java.sql.Connection;
/*
单个的连接50个用了
用时1223.0毫秒
连接池连接50000
6743.0毫秒
* */

/*
* 单个第连接，每一次的连接都要建立一个新的连接，
* 而连接池中是初始化时创建了几个连接放在连接池中，反复的使用，节约了创建的时间，可以看出，创建的时间还是很长的
* 建立的连接多了，数据看还不让你建立，会发生异常。就是所不让你建立那么多的连接
*
* */
public class Test {
    public static void main(String[] args) {
        System.out.println("使用连接单一连接50次");
        JdbcTest j =new JdbcTest();
       double time= System.currentTimeMillis();
        for (int i = 0; i <50 ; i++) {
            j.getConnection();
        }
        double time2= System.currentTimeMillis();
        double all=time2-time;
        System.out.println("用时"+all);


        System.out.println("连接池连接50000");
        time=System.currentTimeMillis();


        Connection connection=null;
        for (int i = 0; i < 500000; i++) {
          connection= Pool_manager.getConnection();
            Pool_manager.releaseConnection(connection);
        }


        time2=System.currentTimeMillis();
        all=time2-time;
        System.out.println(all);
    }
}

