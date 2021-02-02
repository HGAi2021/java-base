package thread;

/**
 * @author HGAI
 * @version v1
 * @date 2021/1/8 0008 23:37
 * @description 使用实现Runnable接口的方式，售票
 */

class Window1 implements Runnable {
     int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票 : 票号为 : " + ticket--);
            } else {
                break;
            }
        }
    }
}
public class TestWindow1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);
        t1.start();
        t2.start();
        t3.start();
    }
}
