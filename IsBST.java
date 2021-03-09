package binarySearchTreeDs;

public class IsBST {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(isBST(root));
        System.out.println(isBSTMoreEff(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBSTMostEff(root, new Previous(Integer.MIN_VALUE)));
    }

    public static boolean isBST(Node root) {
        if (root == null)
            return true;
        if (root.left != null && max(root.left) > root.data)
            return false;
        if (root.right != null && min(root.right) < root.data)
            return false;
        if (!isBST(root.right) || !isBST(root.left))
            return false;
        return true;
    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int max = root.data;
        int lMax = max(root.left);
        int rMax = max(root.right);
        if (lMax > max)
            max = lMax;
        if (rMax > max)
            max = rMax;
        return max;
    }

    public static int min(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int min = root.data;
        int lMin = min(root.left);
        int rMin = min(root.right);
        if (lMin < min)
            min = lMin;
        if (rMin < min)
            min = rMin;
        return min;
    }

    public static boolean isBSTMoreEff(Node root, int min, int max) {
        if (root == null)
            return true;
        return (root.data < max && root.data > min) &&
                isBSTMoreEff(root.left, min, root.data) &&
                isBSTMoreEff(root.right, root.data, max);
    }

    public static boolean isBSTMostEff(Node root, Previous previous) {
        if (root == null)
            return true;
        if (!isBSTMostEff(root.left, previous))
            return false;
        if (previous.getPrevious() >= root.data)
            return false;
        previous.setPrevious(root.data);
        if (!isBSTMostEff(root.right, previous))
            return false;
        return true;
    }
}

class Previous {
    private int previous;

    Previous(int previous) {
        this.previous = previous;
    }

    int getPrevious() {
        return previous;
    }

    void setPrevious(int previous) {
        this.previous = previous;
    }
}
