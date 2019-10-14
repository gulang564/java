package test1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
/*
* 并发，使用多线程时，可以使用实现runnable，或者Callable，使用前者会调用get方法，是没有返回值的
* 但是后者就有，
* 使用线程池来获取线程时，调用submit方法，可以生成Future 对象
* 这个对象顾名思义，是未来的对象，
* 也就是说，这个对象在未来的一定是存在的。使用线程池的submit方法，会直接生成这个对象，这个对象也很神奇
* 不管程序(函数)执行完了没，这个对象都是存在的。但是这个对象有个特点。
* 就是：在函数执行完之前，你是拿不到函数的结果的，当然了，这是必然的结果，事都没做完哪来的结果呢
* */

/*
* 这种方式适用于处理那种运算时间长的程序，但是暂时我们也不需要结果，就让它算，其他的我们该干什么干什么。
* 当我们需要结果的时候，也就是一段时间过后，我们想起来，还有这个事，程序也算完了，我们就用get方法获取程序的
* 返回值
* */
public class Thread_pool {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c =  new MyCallable(i + " ");
            // 执行任务并获取Future对象,submit之后就会生成一个future对象
            Future f = pool.submit(c);
             System.out.println(">--------------->>" + f.get().toString());
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        System.out.println("正在的开始");
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
}
