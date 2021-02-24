package binarySearchTreeDs;

public class DeleteKey {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        inorder(root);
        System.out.println();
        deleteKey(root, 12);
        inorder(root);
    }

    public static Node deleteKey(Node root, int x) {
        if (root == null)
            return null;
        if (root.data > x) {
            root.left = deleteKey(root.left, x);
        } else if (root.data < x)
            root.right = deleteKey(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node temp = getSuccessor(root);
                root.data = temp.data;
                deleteKey(root.right, temp.data);
            }
        }
        return root;
    }

    public static Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null)
            curr = curr.left;
        return curr;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
