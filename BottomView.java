package binarySearchTreeDs;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        bottomView(root);
    }

    public static void bottomView(Node root) {
        if (root == null)
            return;
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node curr = p.node;
            treeMap.put(p.hDistance, curr.data);
            if (curr.left != null)
                queue.offer(new Pair(curr.left, p.hDistance - 1));
            if (curr.right != null)
                queue.offer(new Pair(curr.right, p.hDistance + 1));
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet())
            System.out.print(entry.getValue() + " ");
    }
}
