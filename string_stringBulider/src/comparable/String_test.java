package comparable;
/*
* 使用String 与StringBuilder拼接字符串是
* 实现相同的操作，各自拼接字符串50000次
* String需要18037毫秒
* StringBuilder 需要5毫秒(仅在本机运行的结果)
* */
public class String_test {
    public static void main(String[] args) {
        long string_startTime=System.currentTimeMillis();
        String s="";

        for (int i = 0; i <50000 ; i++) {
            s=s+i;
        }
        long string_endTime=System.currentTimeMillis();

        long string_time=string_endTime-string_startTime;

        System.out.println(string_time);


        long sb_start=System.currentTimeMillis();



        StringBuilder sb=new StringBuilder("");
        for (int i = 0; i <50000 ; i++) {
            sb.append(i);
        }
        //System.out.println(sb);
        long sb_end=System.currentTimeMillis();

        long sb_time=sb_end-sb_start;
        System.out.println(sb_time);
    }
}
