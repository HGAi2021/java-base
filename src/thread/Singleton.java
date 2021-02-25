package thread;

/**
 * @author HGAi
 * @date 2021/2/25 0025 17:38
 * 单例模式 懒汉模式 线程安全模式
 */
// 一般方法内，使用同步代码块，可以考虑this
// 对于静态方法内，使用当前类本身充当锁
public class Singleton {
    private Singleton () {

    }
    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class TestSingleton {
    public static void main(String[] args) {
        Singleton s1  =  Singleton.getInstance();
        Singleton s2  =  Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
