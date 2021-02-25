package thread;


/**
 * @author HGAi
 * @date 2021/2/25 0025 18:06
 * 死锁问题
 * 实例1  在下面的简单实例中，我们同时开启两个线程X、Y，
 * 线程X加sb1锁后，会在再次加sb2锁，
 * 线程Y加sb2锁后，会在再次加sb1锁,
 * 当线程X加sb1锁后，会在再次加sb2锁，
 * 同时
 * 线程Y加sb2锁后，再次等待X持有的sb1锁时，
 * 就会出现相互等待，便产生了死锁问题。
 */
public class TestDeadLock {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (sb1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized (sb2) {
                        sb2.append("B");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        } .start();

        new Thread() {
            @Override
            public void run() {
                synchronized (sb2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("C");
                    synchronized (sb1) {
                        sb2.append("D");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        } .start();
    }
}
