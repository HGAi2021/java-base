package collection;

import java.util.*;

public class demo2 {
    public static void main(String[] args) {
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add("AA");
        System.out.println("coll1集合内容："+coll1);
        //集合遍历 for循环 是 数组的遍历
        //iterator():返回一个Iterator接口实现类的对象
        Iterator iterator = coll1.iterator();
        System.out.println("iterator.next()--1:"+iterator.next());
        System.out.println("iterator.next()--2:"+iterator.next());
        /**
         * v1
         */
        for(int i =0;i<coll1.size();i++){
            System.out.println("iterator.next()--"+i+":"+iterator.next());
        }
        /**
         * V2
         */
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
