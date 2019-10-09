

public class Server{
    public static void main(String[] args) {
        ServerImp serverImp=new ServerImp();
       Thread thread=new Thread(serverImp);
       thread.start();
        System.out.println("搞完了");
    }


}
