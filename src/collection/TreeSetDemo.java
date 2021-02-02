package collection;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        /**
         * 定制排序compartor
         * 创建一个实现了Comparater接口类的对象
         * comparable 是自然排序
         */
     /*   Comparator com =new Comparator() {
            *//**
             * Object 重写了equals方法
             * 向TreeSet中添加Customer类的对象，在此compare()方法中，指明是按照Customer的哪个属性排序的
             * @param o1
             * @param o2
             * @return
             *//*
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer&& o2 instanceof Customer){
                    Customer c1= (Customer)o1;
                    Customer c2= (Customer)o2;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i==0){
                        return c1.getName().compareTo(c2.getName());
                    }
                }
                return 0;
            }
        };*/
        // 将此对象做为形参传递给TreeSet的构造器中
        TreeSet set =new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer&& o2 instanceof Customer){
                    Customer c1= (Customer)o1;
                    Customer c2= (Customer)o2;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i==0){
                        return c1.getName().compareTo(c2.getName());
                    }
                    return i;
                }
                return 0;
            }
        });
        // 向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象。
        set.add(new Customer("AA",1003));
        set.add(new Customer("BB",1004));
        set.add(new Customer("CC",1005));
        set.add(new Customer("DD",1006));
        set.add(new Customer("EE",1007));
        set.add(new Customer("FF",1008));
        set.add(new Customer("GG",1009));
        System.out.println(set);
    }
    @Test
    public void test_contains(){
        Collection c = new ArrayList(){{
                add(123);
                add(456);
            }};
        boolean contains = c.contains(123);
        System.out.println(contains);
    }
}
