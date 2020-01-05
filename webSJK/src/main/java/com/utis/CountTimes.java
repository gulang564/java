package com.utis;

import java.util.Arrays;

public class CountTimes {
    public static int countDay(String start,String end){

        System.out.println("进入计算天数的程序");
        String[] starts=start.substring(0,10).split("-");
        System.out.println(Arrays.toString(starts));
        String [] ends=end.split("-");
        System.out.println(Arrays.toString(ends));

        if(Integer.parseInt(ends[2])<Integer.parseInt(starts[2])){
            ends[1]=(Integer.parseInt(ends[1])-1)+"";
            ends[2]=(Integer.parseInt(ends[2])+30)+"";
        }

        if (Integer.parseInt(ends[1])<Integer.parseInt(starts[1])){
            ends[0]=(Integer.parseInt(ends[0])-1)+"";
            ends[1]=(Integer.parseInt(ends[1])+12)+"";
        }
        /*未来的年份一定是大的数据，所以不用管*/
        int year= Integer.parseInt(ends[0])-Integer.parseInt(starts[0]);
        int month=Integer.parseInt(ends[1])-Integer.parseInt(starts[1]);
        int day=Integer.parseInt(ends[2])-Integer.parseInt(starts[2]);

        return year*365+month*30+day;
    }
}
