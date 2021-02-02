package collection;


import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("123");
        set.add("456");
        set.add("AA");
        set.add("BB");
        set.add(null);
        set.add(null);
        System.out.println("set包含的内容："+set.toString());
        Iterator i = set.iterator();

    }
}
