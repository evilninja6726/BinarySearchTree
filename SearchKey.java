package binarySearchTreeDs;


public class SearchKey {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
        System.out.println(searchKey(root, 16));
        System.out.println(searchKeyIt(root, 17));
    }

    public static boolean searchKey(Node root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        else if (root.data > x)
            return searchKey(root.left, x);
        else
            return searchKey(root.right, x);
    }

    public static boolean searchKeyIt(Node root, int x) {
        while (root != null) {
            if (root.data == x)
                return true;
            else if (root.data > x)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}