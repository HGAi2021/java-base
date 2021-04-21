package jdk;

import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author HGAi
 * @date 2021/4/22 0022 0:20
 * 方法引用
 * 若 Lambda 表达式体中的内容已有方法实现，则我们可以使用方法引用
 * 或 Lambda 参数列表中的第一个参数是方法的调用者，第二个参数是方法的参数时，才能使用 ClassName :: Method
 *
 * 注：
 * 实现：Lambda 表达实体中调用方法的参数列表、返回类型必须和函数式接口中抽象方法保持一致
 *
 * 语法格式：
 * 对象 :: 实例方法
 * 类 :: 静态方法
 * 类 :: 实例方法
 *
 *
 * 构造器引用
 *
 * 格式
 * 类 :: new
 *
 * 注意：
 * 需要调用的构造器的参数列表要与函数时接口中抽象方法的参数列表保持一致
 *
 * 数组引用
 * 类 :: new
 */
public class ReferenceConstructor {
    /**
     * 对象 :: 实例方法
     */
    @Test
    public void test1() {
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("consumer () - 输出：" + integer);
            }
        };
        consumer.accept(200);

        // 简写
        final PrintStream printStream = System.out;
        Consumer<Integer> consumer1 = printStream::print;
        consumer1.accept(300);
    }

    /**
     * 类 :: 静态方法
     */
    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Integer 提供了 compare() 方法
                return Integer.compare(o1, o2);
            }
        };
        final int compare = comparator.compare(1, 2);
        System.out.println(compare);

        // 简写
        Comparator<Integer> comparator1 = Integer::compare;
        final int compare1 = comparator1.compare(1, 2);
        System.out.println(compare1);
    }
    /**
     * Boolean BiPredicate<T,R>  是 Boolean Predicate<T> 的子接口
     * 类 :: 实例方法
     */
    @Test
    public void test3() {
        BiPredicate<String,String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        final boolean test = biPredicate.test(1 + "", 1 + "");
        System.out.println(test);
        // 简写
        BiPredicate<String, String> biPredicate1 = String::equals;
        final boolean test1 = biPredicate.test(1 + "", 2 + "");
        System.out.println(test1);
    }

    /**
     * 构造器引用
     * 无参构造器
     */
    @Test
    public void  test4() {
        Supplier<List> supplier = new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList();
            }
        };
        final List list = supplier.get();
        // 简写
        Supplier<List> supplier1 = () -> new ArrayList();
        final List list2 = supplier1.get();

        // 构造器引用
        Supplier<List> supplier2 = ArrayList::new;
        final List list3 = supplier.get();
    }

    /**
     * 构造器引用
     * 有参构造器引用
     */
    @Test
    public void test5() {
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return new Integer(integer);
            }
        };
        final Integer apply = function.apply(2);
        System.out.println(apply);

        // 简化
        Function<Integer, Integer> function1 = x -> new Integer(x);
        final Integer apply1 = function1.apply(2);
        System.out.println(apply1);

        // 简化
        Function<Integer, Integer> function2 = Integer::new;
        final Integer apply2 = function2.apply(2);
        System.out.println(apply2);
    }

    /**
     * 数组引用
     */
    @Test
    public void test6() {
        Function<Integer, String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        function.apply(5);

        // 简化
        Function<Integer,String[]> function1 = x -> new String[x];
        function1.apply(5);
    }

}
