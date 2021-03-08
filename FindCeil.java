package binarySearchTreeDs;

public class FindCeil {
    public static void main(String[] args) {
        Node root=new Node(15);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.right=new Node(20);
        root.right.left=new Node(18);
        root.right.left.left=new Node(16);
        root.right.right=new Node(80);
        System.out.println(findCeil(root,17).data);
    }

    public static Node findCeil(Node root, int x) {
        if (root == null)
            return null;
        Node ceil = null;
        while (root != null) {
            if (root.data == x)
                return root;
            else if (root.data < x)
                root = root.right;
            else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil;
    }
}
