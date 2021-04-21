package jdk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @author HGAi
 * @date 2021/4/21 0021 23:32
 * 函数式接口
 * Java内置 四大核心 函数式接口
 * 以及 其他接口
 *
 */
public class FunctionInterface {
    /**
     * T UnaryOperator<T> 是 R Function<T, R> R apply<T> 的子接口
     * 函数型接口
     */
    @Test
    public void test01() {
        //  原版本
        final UnaryOperator unaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        };
        System.out.println( unaryOperator.apply(2));
        // 简写
        UnaryOperator<Integer> unaryOperator1 = t ->  + 2 ;
        unaryOperator.apply(2);
    }

    /**
     * R Function<T, R>  R apply<T>
     * 函数型接口
     */
    @Test
    public void test02() {
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
    }

    /**
     * Supplier<T>
     *     T get()
     * 提供型接口
     */
    @Test
    public void test03() {
        List<Integer> resList = new ArrayList<>();
        List<Integer> tempList = Arrays.asList(1, 2, 3);
        resList.addAll(tempList);
        System.out.println("test02 () - resList >>> " + resList);
        final Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 10);
            }
        };
        resList.add(supplier.get());
        System.out.println("test02 () - resList >>> " + resList);

        // 简写
        Supplier supplier1 = () -> Math.random() * 10;
        System.out.println("supplier1 >>> " + supplier1.get());
    }

    /**
     * Consumer<T>  void accept (T t)
     * 消费型接口
     */
    @Test
    public void test04() {
        final Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("test3 () - 输出: " + integer);
            }
        };
        consumer.accept(200);

        // 简写
        Consumer<Integer> consumer1 = x -> System.out.println(x);
        consumer1.accept(100);
    }

    /**
     * Boolean BiPredicate<T,R>  是 Boolean Predicate<T> 的子接口
     * 断言型接口
     */
    @Test
    public void test05() {
        BiPredicate<String,String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        final boolean test = biPredicate.test(1 + "", 1 + "");
        System.out.println(test);

        // 简写
        BiPredicate<String, String> biPredicate1 = (x, y) -> x.equals(y);
        final boolean test1 = biPredicate.test(1 + "", 2 + "");
        System.out.println(test1);
    }


}
