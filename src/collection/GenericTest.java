package collection;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        GenericDemo<Boolean> g = new GenericDemo();
//        g.getT();// 在new 对象的时候，没使用泛型 则为Object
//        g.getT();// 在new 对象的时候，使用泛型了，boolean类型了
/*          g.setT(true);
        System.out.println(g.getT());
        g.add();
        List<Boolean> list = g.list;
        System.out.println(list);

        SubOrder o = new SubOrder();
        //Integer类型
        List<Integer>list1 =o.list;*/
        //泛型方法
        //当通过对象调泛型方法时，指明泛型方法的类型。
        Integer e = g.getE(32);
        Double e1 = g.getE(2.3);

        Integer []in =new Integer[]{1,2,3};
        List<Integer>list =new ArrayList<>();
        List<Integer> integers = g.fromArrayToList(in, list);
        System.out.println(integers.toString());


        Object[] obj1 = null;
        String[] str = new String[]{"AA","BB","CC",};
        obj1 = str;

/*        List<Object> list11 =null;
        List<String>list22 = new ArrayList<>();
        list11 = list22;*/


    }
}
