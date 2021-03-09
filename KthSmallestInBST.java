package binarySearchTreeDs;

public class KthSmallestInBST {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
        kthSmallestInBST(root, 3, new Count(0));
        System.out.println();
        NodeWithLCount root1 = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};

        for (int x : keys)
            root1 = insert(root1, x);

        kthSmallestInBSTEff(root1, 3);
    }

    public static void kthSmallestInBST(Node root, int k, Count count) {
        if (root != null) {
            Count c = new Count(0);
            kthSmallestInBST(root.left, k, c);
            count.setCount(c.getCount() + 1);
            if (count.getCount() == k) {
                System.out.println(root.data);
                return;
            }
            kthSmallestInBST(root.right, k, c);
        }
    }

    public static void kthSmallestInBSTEff(NodeWithLCount root, int k) {
        if (root == null)
            return;
        int count = root.lCount + 1;
        if (count == k) {
            System.out.println(root.data);
            return;
        } else if (count > k) {
            kthSmallestInBSTEff(root.left, k);
        } else {
            kthSmallestInBSTEff(root.right, k - count);
        }
    }

    public static NodeWithLCount insert(NodeWithLCount root, int x) {
        if (root == null)
            return new NodeWithLCount(x);
        if (root.data < x) {
            root.right = insert(root.right, x);
        } else if (root.data > x) {
            root.left = insert(root.left, x);
            root.lCount++;
        }
        return root;
    }
}

class Count {
    private int count;

    Count(int count) {
        this.count = count;
    }

    int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
    }
}

class NodeWithLCount {
    int data;
    int lCount;
    NodeWithLCount left, right;

    NodeWithLCount(int data) {
        this.data = data;
    }
}