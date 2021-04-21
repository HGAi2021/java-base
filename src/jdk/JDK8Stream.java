package jdk;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author HGAi
 * @date 2021/4/21 0021 23:05
 * Stream 三个操作步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作(终端操作)
 */
public class JDK8Stream {
    @Test
    public void test1() {

        // 1、通过Collection 系列集合提供的stream() 串行流 或 parallelStream() 并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2、通过Arrays 中的静态方法 stream() 获取数组流
        String[] strings = {"AA", "BB", "CC"};
        Stream<String> stream1 = Arrays.stream(strings);

        // 3、通过Stream 类 中的静态方法
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4、创建无限流 迭代
        final UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("unaryOperator  - 被调用了 ");
                return integer + 2;
            }
        };
        final Stream<Integer> stream4 = Stream.iterate(0, unaryOperator);

        stream4.limit(10).forEach(System.out::print);

        // 5、生成
        final Supplier<Double> supplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        final Stream<Double> generate = Stream.generate(supplier);
        Consumer<Double> consumer = x -> System.out.println(x);
        generate.limit(5).forEach(consumer);

    }
}
