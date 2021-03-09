package binarySearchTreeDs;

import java.util.ArrayList;
import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);
        System.out.println(treeToArrayList(root, new ArrayList<>()));
        System.out.println();
        System.out.println(pairWithGivenSum(treeToArrayList(root, new ArrayList<>()), 17));
        System.out.println(pairWithGivenSumHashing(root, new HashSet<>(), 16));
    }

    public static boolean pairWithGivenSum(ArrayList<Integer> arrayList, int sum) {
        int l = 0, h = arrayList.size() - 1;
        while (l < h) {
            if (arrayList.get(l) + arrayList.get(h) == sum)
                return true;
            if (arrayList.get(l) + arrayList.get(h) < sum)
                l++;
            else
                h--;
        }
        return false;
    }

    public static ArrayList<Integer> treeToArrayList(Node root, ArrayList<Integer> arrayList) {
        if (root != null) {
            treeToArrayList(root.left, arrayList);
            arrayList.add(root.data);
            treeToArrayList(root.right, arrayList);
        }
        return arrayList;
    }

    public static boolean pairWithGivenSumHashing(Node root, HashSet<Integer> hashSet, int sum) {
        if (root != null) {
            if (pairWithGivenSumHashing(root.left, hashSet, sum))
                return true;
            if (hashSet.contains(sum - root.data))
                return true;
            else
                hashSet.add(root.data);
            if (pairWithGivenSumHashing(root.right, hashSet, sum))
                return true;
        }
        return false;
    }
}
