package binarySearchTreeDs;

public class InsertKey {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        insertKey(root, 100);
        insertKeyIt(root, 11);
        inorder(root);
    }

    public static Node insertKey(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (root.data > x)
            root.left = insertKey(root.left, x);
        else
            root.right = insertKey(root.right, x);
        return root;
    }

    public static Node insertKeyIt(Node root, int x) {
        Node temp = new Node(x);
        Node curr = root, prev = null;
        while (curr != null) {
            prev = curr;
            if (curr.data < x)
                curr = curr.right;
            else if (curr.data > x)
                curr = curr.left;
            else
                return root;
        }
        if (prev == null)
            return temp;
        if (prev.data > x)
            prev.left = temp;
        else
            prev.right = temp;
        return root;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
