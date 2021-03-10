package binarySearchTreeDs;

import java.util.*;

public class VerticalTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        verticalTraversal(root);
    }

    public static void verticalTraversal(Node root) {
        if (root == null)
            return;
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node curr = p.node;
            if (!treeMap.containsKey(p.hDistance)) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(curr.data);
                treeMap.put(p.hDistance, arrayList);
            } else {
                treeMap.get(p.hDistance).add(curr.data);
            }
            if (curr.left != null)
                queue.offer(new Pair(curr.left, p.hDistance - 1));
            if (curr.right != null)
                queue.offer(new Pair(curr.right, p.hDistance + 1));
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {
            ArrayList<Integer> arrayList = entry.getValue();
            for (int x : arrayList)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

class Pair {
    Node node;
    int hDistance;

    Pair(Node node, int hDistance) {
        this.node = node;
        this.hDistance = hDistance;
    }
}