import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static  void show(){
        System.out.println("服务器只认识"+"<register name=xu/>"+"其中的register可以替换为login,loginout");
        System.out.println("发送消息是:"+"<message from=xu to=zhang message=this is a test");

    }
    public static void main(String[] args) {
        String msg="";
        try {
            Socket socket=new Socket("127.0.0.1",8081);
            PrintWriter pw=new PrintWriter(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发消息

            while (true){
                show();
                System.out.println("要发送的消息为:");
                Scanner scanner=new Scanner(System.in);
                msg=scanner.nextLine();
                pw.println(msg);
                pw.flush();
                //接收消息
                String line=br.readLine();
                if(line.contains("loginout")){
                    System.out.println("退出系统，拜拜了");
                    break;
                }
                if(line.contains("<message from='xu' to='zhang' message='this is a test"))
                {
                    pw.println("<result command='message' state='ok'");
                }
                System.out.println("收到的消息为-------------:"+line);
            }
            pw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
