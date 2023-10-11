import java.util.Scanner;

class BinaryNodeRevamped<T extends Comparable<T>> {
    T data;
    BinaryNodeRevamped<T> leftNode;
    BinaryNodeRevamped<T> rightNode;

    public BinaryNodeRevamped(T item) {
        this.data = item;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryNodeRevamped(T item, BinaryNodeRevamped<T> leftNode, BinaryNodeRevamped<T> rightNode) {
        this.data = item;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getData() {
        return this.data;
    }

    public BinaryNodeRevamped<T> getLeft() {
        return this.leftNode;
    }

    public BinaryNodeRevamped<T> getRight() {
        return this.rightNode;
    }

    public boolean isLeaf() {
        return this.leftNode == null && this.rightNode == null;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public void inOrder(BinaryNodeRevamped<T> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void preOrder(BinaryNodeRevamped<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void postOrder(BinaryNodeRevamped<T> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void setLeft(BinaryNodeRevamped<T> tBinaryNodeRevamped) {
        this.leftNode = tBinaryNodeRevamped;
    }

    public void setRight(BinaryNodeRevamped<T> tBinaryNodeRevamped) {
        this.rightNode = tBinaryNodeRevamped;
    }

    // Create toString() method that also returns the left and right children as well for BinaryNodeRevamped<T> class
    @Override
    public String toString() {
        return "BinaryNodeRevamped{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

public class MaxHeap<T extends Comparable<T>> {
    private BinaryNodeRevamped<T> root;

    // Other constructors and methods...

    public void insert(T data) {
        BinaryNodeRevamped<T> newNode = new BinaryNodeRevamped<>(data);

        if (root == null) {
            root = newNode;
        } else {
            insertRecursive(root, newNode);
        }
    }

    private void insertRecursive(BinaryNodeRevamped<T> current, BinaryNodeRevamped<T> newNode) {
        // Maintain the MaxHeap property by swapping if necessary
        if (current.getData().compareTo(newNode.getData()) < 0) {
            T temp = newNode.getData();
            newNode.setData(current.getData());
            current.setData(temp);
        }

        if (current.getLeft() == null) {
            // If the left child is null, insert the newNode here
            current.setLeft(newNode);
        } else if (current.getRight() == null) {
            // If the right child is null, insert the newNode here
            current.setRight(newNode);
        } else {
            // Both left and right children exist; compare with both
            if (current.getLeft().getData().compareTo(current.getRight().getData()) > 0) {
                // The left child is smaller, so insert there
                insertRecursive(current.getLeft(), newNode);
            } else {
                // The right child is smaller, so insert there
                insertRecursive(current.getRight(), newNode);
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer to insert into the Max Heap (or -1 to exit): ");
            int input = scanner.nextInt();

            if (input == -1) {
                break;
            }

            maxHeap.insert(input);

            System.out.print("Post-order traversal after insertion: ");
            maxHeap.root.postOrder(maxHeap.root);
            System.out.println();
        }

        scanner.close();
    }
}