package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 通配符 ？
 * List<A>、List<B>都是List<?>的子集
 */
public class WildcardDemo {
    @Test
    public void test1(){
        List<String > list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        List<?> list1 = list;
        Iterator<?> iterator = list1.iterator();
        while (iterator.hasNext()){
            //返回Object
            System.out.println(iterator.next());
        }
//        list1.add("cc");
        list1.add(null);

    }
    public static void main(String[] args) {
        List<?>list =null;
        List<Object >list1 = new ArrayList<>();
        List<String >list2= new ArrayList<>();
        list = list1;
        list = list2;
        show1(list1);
        show1(list2);

        List<? extends Number> list3 = null;
        List<Integer> list4 = null;
        list3=list4;
//        List<? super Number> list5 = null;
//        List<Integer> list4 = null;
//        list5=list4;
    }
    public static void show(List<Object >list){

    }
    public static void show1(List<?> list){

    }
}
