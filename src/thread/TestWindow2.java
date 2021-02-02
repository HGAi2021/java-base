package thread;

/**
 * @author HGAI
 * @version v1
 * @date 2021/1/8 0008 23:37
 * @description 使用实现Runnable接口的方式，售票
 */

class window2 implements Runnable {
    // 共享数据
     int ticket = 100;
     // 同步监视器 即 锁
     Object object = new Object();
    @Override
    public void run() {
        while (true) {
            // 操作共享数据的代码
//            synchronized (object) {
            synchronized (this) {
                // this 表示当前对象，本题中为window
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票 : 票号为 : " + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}


public class TestWindow2 {
    public static void main(String[] args) {
        window2 window2 = new window2();
        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window2);
        t1.start();
        t2.start();
        t3.start();
    }
}
