package thread;

/**
 * @author H_Java
 */
public class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i =0;i<=100;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

}


