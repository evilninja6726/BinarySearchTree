package binarySearchTreeDs;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        verticalSum(root);
    }

    public static void verticalSum(Node root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        fillTreeMap(treeMap, root, 0);
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet())
            System.out.println(entry.getValue());
    }

    public static void fillTreeMap(TreeMap<Integer, Integer> treeMap, Node root, int hDistance) {
        if (root == null)
            return;
        fillTreeMap(treeMap, root.left, hDistance - 1);
        int pSum = treeMap.get(hDistance) == null ? 0 : treeMap.get(hDistance);
        treeMap.put(hDistance, pSum + root.data);
        fillTreeMap(treeMap, root.right, hDistance + 1);
    }
}
