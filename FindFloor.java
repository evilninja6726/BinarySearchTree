package binarySearchTreeDs;

public class FindFloor {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
        System.out.println(findFloor(root, 17).data);
    }

    public static Node findFloor(Node root, int x) {
        if (root == null)
            return null;
        Node floor = null;
        while (root != null) {
            if (root.data == x)
                return root;
            else if (root.data > x)
                root = root.left;
            else {
                floor = root;
                root = root.right;
            }
        }
        return floor;
    }
}
