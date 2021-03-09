package binarySearchTreeDs;

import static binarySearchTreeDs.InsertKey.inorder;

public class FixBSTWithTwoSwaps {
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(60);
        root.right = new Node(70);
        root.left.left = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(80);

        inorder(root);
        System.out.println();
        fixBSTWithTwoSwaps(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        inorder(root);
    }

    static Node prev = null, first = null, second = null;

    public static void fixBSTWithTwoSwaps(Node root) {
        if (root == null)
            return;
        fixBSTWithTwoSwaps(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        fixBSTWithTwoSwaps(root.right);
    }
}