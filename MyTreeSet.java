package binarySearchTreeDs;

import java.util.Iterator;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Rajat");
        treeSet.add("Pushkar");
        treeSet.add("Osam");
        treeSet.add("Rajat");
        System.out.println(treeSet);
        System.out.println(treeSet.contains("Rajat"));
        System.out.println(treeSet.contains("Nasir"));
        System.out.println(treeSet.ceiling("Rajat"));
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
