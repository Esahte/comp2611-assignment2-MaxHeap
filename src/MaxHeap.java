import java.util.ArrayList;
import java.util.List;
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
}

public class MaxHeap<T extends Comparable<T>> {
    private BinaryNodeRevamped<T> root;

    public MaxHeap() {
        this.root = null;
    }

    public void insertMaxHeap(T element) {
        BinaryNodeRevamped<T> newNode = new BinaryNodeRevamped<>(element);

        if (root == null) {
            root = newNode;
        } else {
            insertMaxHeap(root, newNode);
        }
    }

    private void insertMaxHeap(BinaryNodeRevamped<T> current, BinaryNodeRevamped<T> newNode) {
        while (current != null) {
            if (current.getData().compareTo(newNode.getData()) < 0) {
                T temp = newNode.getData();
                newNode.setData(current.getData());
                current.setData(temp);
            }
            if (current.getLeft() != null && current.getRight() != null) {
                if (current.getLeft().getData().compareTo(current.getRight().getData()) > 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            } else if (current.getLeft() != null) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            insertMaxHeap(current, newNode);
        }
    }

//    public void insertMaxHeap(BinaryNodeRevamped<T> root, T value) {
//        BinaryNodeRevamped<T> newNode = new BinaryNodeRevamped<>(value);
//
//        if (root == null) {
//            this.data = value;
//            return;
//        }
//
//        List<BinaryNodeRevamped<T>> queue = new ArrayList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            BinaryNodeRevamped<T> currentNode = queue.get(0);
//
//            if (currentNode.getLeft() == null) {
//                currentNode.leftNode = newNode;
//                break;
//            } else if (currentNode.getRight() == null) {
//                currentNode.rightNode = newNode;
//                break;
//            } else {
//                queue.add(currentNode.getLeft());
//                queue.add(currentNode.getRight());
//            }
//
//            queue.remove(0);
//        }
//
//        BinaryNodeRevamped<T> parent = newNode.getParent(root);
//        while (parent != null && newNode.getData().compareTo(parent.getData()) > 0) {
//            T temp = newNode.getData();
//            newNode.setData(parent.getData());
//            parent.setData(temp);
//            newNode = parent;
//            parent = newNode.getParent(root);
//        }
//    }

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

            System.out.print("Post-order traversal after insertion: ");
            maxHeap.root.postOrder(maxHeap.root);
            System.out.println();
        }

        scanner.close();
    }
}