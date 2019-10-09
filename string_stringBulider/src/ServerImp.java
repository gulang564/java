import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 使用PrintWriter的时候，用readline读取数据，要用println来回写，，println在末尾自动添加回车
* 而readline识别的也是回车，这样一句话就刚刚好可以读取。
*
* */
public class ServerImp implements Runnable {
    ServerSocket serverSocket=null;
    Socket socket=null;
    PrintWriter pw=null;
    BufferedReader bufferedReader=null;

    public void register(String line){
        if(line.contains("<register name=xu"))
        {
            System.out.println("收到消息为:"+line);
            pw.println("<result command=register state=ok/>");
        }else {
            pw.println("<result command=register state=error message=register error/>");
        }
    }

    public void login(String line){
        if(line.contains("<login name=xu"))
        {
            System.out.println("收到消息为:"+line);
            pw.println("<result command=login state=ok/>");
        }else {
            pw.println("<result command=login state=error message=login error/>");
        }
    }

    public void loginout(String line){
        if(line.contains("<loginout name=xu"))
        {
            System.out.println("收到消息为:"+line);
            pw.println("<result command=loginout state=ok/>");
        }else {
            pw.println("<result command=loginout state=error message=loginout error/>");
        }
    }
    public void from_to(String line){
        if(line.contains("<message from=xu to=zhang message=this is a test")){
            System.out.println("收到消息为:"+line);
            pw.println("<result command=message state=ok/>");
        }else {
            pw.println("<result command=message state=error message=from to error/>");
        }
    }

    @Override
    public void run() {
        try {
             serverSocket= new ServerSocket(8081);
            socket=serverSocket.accept();
             while (true){

                  bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

                 String line =bufferedReader.readLine();
                 pw=new PrintWriter(socket.getOutputStream());

                 if(line.contains("register")){
                     register(line);
                 }else if(line.contains("loginout")){
                     loginout(line);
                     break;
                 } else if (line.contains("login")){
                     login(line);
                 }else if(line.contains("from")&&line.contains("to"))
                 {
                     from_to(line);
                 }else {
                     pw.println("再输入一遍吧");
                 }
                 pw.flush();
             }

            //关流了，一次就结束了
            pw.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
