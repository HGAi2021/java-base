package thread;

/**
 * @author HGAI
 * @version v1
 * @date 2021/1/8 0008 23:16
 * @description
 * 模拟火车售票窗口，开启三个窗口售票，总票数为100张
 */

class Window3 extends Thread {
    static int ticket = 100;
    static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized (this) { // 在本问题中，this表示：w1，w2，w3 因此this不可以
            synchronized (obj) { // 在本问题中，this表示：w1，w2，w3 因此this不可以
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

public class TestWindow3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

}
