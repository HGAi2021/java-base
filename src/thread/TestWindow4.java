package thread;

/**
 * @author HGAI
 * @version v1
 * @date 2021/1/8 0008 23:37
 * @description 同步方法
 */

class Window4 implements Runnable {
    // 共享数据
    int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }

    }

    public synchronized void show () {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票 : 票号为 : " + ticket--);
        }
    }
}


public class TestWindow4 {
    public static void main(String[] args) {
        Window4 window4 = new Window4();
        Thread t1 = new Thread(window4);
        Thread t2 = new Thread(window4);
        Thread t3 = new Thread(window4);
        t1.start();
        t2.start();
        t3.start();
    }
}
