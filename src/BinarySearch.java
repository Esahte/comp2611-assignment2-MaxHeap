import java.util.Scanner;

public class BinarySearch {
    BinaryNode<Integer> root;

    public BinarySearch(BinaryNode<Integer> root) {
        this.root = root;
    }

    // Insert a new node into the binary search tree
    public void insert(int value) {
        // Check if the root node is null
        if (root == null) {
            // Insert the new node here if root is null
            root = new BinaryNode<>(value);
            return;
        }
        // Recursively insert the new node
        insert(root, value);
    }

    // recursive insert
    public void insert(BinaryNode<Integer> root, int value) {
        // Check if the left node is null
        if (root.getLeft() == null) {
            // Check if the new node is less than the root node
            if (value > root.getData()) {
                // Swap values if new node is less than root node
                int temp = value;
                value = root.getData();
                root.setData(temp);
            }
            root.setLeft(new BinaryNode<>(value));
        } else if (root.getRight() == null) {
            // Check if the left node is less than the new node
            if (value < root.getData()) {
                // Swap values if new node is less than left node
                int temp = value;
                value = root.getData();
                root.setData(temp);
            }
            // Insert the new node here if right is null
            root.setRight(new BinaryNode<>(value));
        } else {
            // Both left and right children exist; compare their depth
            int leftDepth = depth(root.getLeft());
            int rightDepth = depth(root.getRight());

            if (leftDepth <= rightDepth) {
                // Insert into the left child (or subtree)
                insert(root.getLeft(), value);
            } else {
                // Insert into the right child (or subtree)
                insert(root.getRight(), value);
            }
        }
    }

    public int depth(BinaryNode<?> node){
        if(node == null) {
            return 0;
        }

        // Return the number of nodes in the subtree
        return 1 + depth(node.getLeft()) + depth(node.getRight());
    }

    public int findDepth(BinaryNode<Integer> node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = findDepth(node.getLeft());
            int rightDepth = findDepth(node.getRight());
            return 1 + Math.min(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearch tree = new BinarySearch(null);

        System.out.print("Enter the number of Integer values: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integer v
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println("Pre-order traversal of the tree:");
        tree.root.preOrderTraversal();

        int depth = tree.findDepth(tree.root);
        System.out.println("\nDepth of the tree: " + depth);
    }
}