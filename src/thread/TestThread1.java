package thread;

/**
 * @author HGAI
 * @version v1
 * @date 2021/1/8 0008 23:28
 * @description 创建多线程的的方式二：通过实现的方式
 */
class PrintNum1 implements Runnable {

    @Override
    public void run() {
        for (int i =0;i<=100;i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
public class TestThread1 {
    public static void main(String[] args) {
        PrintNum1 printNum1 = new PrintNum1();
        //要想启动一个多线程，必须使用start()方法
        Thread t1 = new Thread(printNum1);
        t1.start();
    }
}
