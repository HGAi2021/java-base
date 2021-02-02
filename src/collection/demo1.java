package collection;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();

        Person p1 = new Person("a", 11, "aaaaa");
        Person p2 = new Person("b", 12, "bbbbb");
        Person p3 = new Person("c", 13, "ccccc");
        Person p4 = new Person("d", 14, "ddddd");
        Person p5 = new Person("e", 15, "eeeee");

        Stream<Person> stream = list.stream();
        Stream<Person> personStream = stream.filter(p -> (p1.getAge() > 13));
        personStream.collect(Collectors.toList());

    }
}
