import java.util.Scanner;

public class Scanner_test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //使用next，读到空格为止，使用nextline，读到回车为止。
        String msg=scanner.nextLine();
        System.out.println(msg);
    }
}
