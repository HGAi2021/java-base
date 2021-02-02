package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection接口
 *      list接口：存储有序，可以重复的元素
 *          实现类 ArrayList、LinkedList、Vector
 *      set接口：存储无序，不可重复的元素
 *         实现类：HashSet、LinkedHashSet、TreeSet
 *  Map接口：存储“键-值”对的数据
 *          实现类：HashMap、LinkedHashMap、TreeMap、Hashtable（子类-Properties）
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add("GG");
        list.add(0,5);
        System.out.println(list);
        List list1 = list.subList(0, 3);
        System.out.println(list1);
    }
}

