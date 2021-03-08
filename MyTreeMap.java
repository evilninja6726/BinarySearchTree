package binarySearchTreeDs;

import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Rajat", 410);
        treeMap.put("Pushkar", 412);
        treeMap.put("Osam", 423);
        treeMap.put("Rajat", 410);
        System.out.println(treeMap);
        System.out.println(treeMap.containsKey("Rajat"));
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(treeMap.ceilingKey("Pushkar"));
        System.out.println(treeMap.floorKey("Pushkar"));
        System.out.println(treeMap.lowerKey("Pushkar"));
        System.out.println(treeMap.higherKey("Pushkar"));
    }
}
