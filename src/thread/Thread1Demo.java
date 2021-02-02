package thread;


public class Thread1Demo {
    /**
     * 创建一个子线程，完成1-100之间自然数的输出。同样地，主线程执行同样的操作。
     */
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.getPriority();
        t1.start();

        for (int i = 0; i <= 100; i++) {
//            if (i % 10 == 0) {
//                Thread.yield();
//            }
//            if (i  == 20) {
//                t1.join();
//            }

            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
