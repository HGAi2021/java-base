package collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put(new Person("BB",25,"24"),81);
        map.put(new Person("AA",24,"24"),82);
        map.put(new Person("CC",26,"24"),83);
        map.put(new Person("EE",28,"24"),84);
        map.put(new Person("DD",27,"24"),85);
        map.put(new Person("FF",29,"24"),86);
        Set set = map.keySet();
        System.out.println(set);
        //定制排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    int i = p2.getAge()-p1.getAge();
                    if(i==0){
                        return p2.getName().compareTo(p1.getName());
                    }
                    return i;
                }
                return 0;
            }

        };
        TreeMap treeMap = new TreeMap(com);
        treeMap.put(new Person("BB",25,"24"),81);
        treeMap.put(new Person("AA",24,"24"),82);
        treeMap.put(new Person("CC",26,"24"),83);
        treeMap.put(new Person("EE",28,"24"),84);
        treeMap.put(new Person("DD",27,"24"),85);
        treeMap.put(new Person("FF",29,"24"),86);
        System.out.println(treeMap);


    }
}
