import java.util.Scanner;

class BinaryNodeRe<T extends Comparable<T>> {
    T data;
    BinaryNodeRe<T> leftNode;
    BinaryNodeRe<T> rightNode;

    public BinaryNodeRe(T item) {
        this.data = item;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryNodeRe(T item, BinaryNodeRe<T> leftNode, BinaryNodeRe<T> rightNode) {
        this.data = item;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getData() {
        return this.data;
    }

    public BinaryNodeRe<T> getLeft() {
        return this.leftNode;
    }

    public BinaryNodeRe<T> getRight() {
        return this.rightNode;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public void postOrderTraversal(BinaryNodeRe<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    // Create a toString method for BinaryNodeRe and its children
    @Override
    public String toString() {
        return "BinaryNodeRe [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
    }

}

public class MaxHeap<T extends Comparable<T>> {
    private BinaryNodeRe<T> root;

    public MaxHeap() {
        this.root = null;
    }

    public void insertMaxHeap(T element) {
        if (element == null) {
            return; // Don't insert null elements.
        }

        BinaryNodeRe<T> newNode = new BinaryNodeRe<>(element);

        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }

    private void insert(BinaryNodeRe<T> current, BinaryNodeRe<T> newNode) {
        if (current == null) {
            return;
        }

        if (newNode.getData().compareTo(current.getData()) > 0) {
            T temp = newNode.getData();
            newNode.setData(current.getData());
            current.setData(temp);
        }

        if (current.getLeft() == null) {
            current.leftNode = newNode;
            return;
        }  else if (current.getRight() == null) {
            current.rightNode = newNode;
            return;
        }

        if (newNode.getData().compareTo(current.getLeft().getData()) > 0) {
            insert(current.getLeft(), newNode);
        } else {
            insert(current.getRight(), newNode);
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

            maxHeap.insertMaxHeap(input);

            System.out.println("Post-order traversal after insertion: ");
            maxHeap.root.postOrderTraversal(maxHeap.root);
            System.out.println();
        }

        scanner.close();
    }
}
