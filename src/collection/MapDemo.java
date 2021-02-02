package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map接口
 *      HashMap:Map主要实现类
 *      LinkedHashMap:
 *      TreeMap:
 *      HashTable
 *          Properties:
 */
public class MapDemo {
    public static void main(String[] args) {
/*
        Map map =new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        */
/**
         * 遍历Key集 keySet
         *//*

        Set set = map.keySet();
        System.out.println(set);
        */
/**
         * 遍历Value values
         *//*

        Collection values = map.values();
        System.out.println(values);
        */
/**
         * 如何遍历Key-Value对
         *
         *//*

        Set set2 = map.entrySet();
        System.out.println(set2);
        for(Object o :set2){
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
*/

        Map<String,Integer>map1 = new HashMap<>();
        map1.put("AA",1);
        map1.put("BB",2);
        map1.put("CC",3);
        Set<Map.Entry<String,Integer>> set1 = map1.entrySet();
        for(Map.Entry<String,Integer> o :set1){
            System.out.println(  "mp1"+ o.getKey());
            System.out.println(        "mp2"+     o.getValue());
        }

    }
}
