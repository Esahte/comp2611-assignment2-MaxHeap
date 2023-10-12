public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }
        System.out.println(data);
        if (right != null) {
            right.inOrderTraversal();
        }
    }

    // Create a postOrderTraversal() method that prints the data of the tree in post-order.
    public void postOrderTraversal() {
        if (left != null) {
            left.postOrderTraversal();
        }
        if (right != null) {
            right.postOrderTraversal();
        }
        System.out.println(data);
    }

    // Create a preOrderTraversal() method that prints the data of the tree in pre-order.
    public void preOrderTraversal() {
        System.out.println(data);
        if (left != null) {
            left.preOrderTraversal();
        }
        if (right != null) {
            right.preOrderTraversal();
        }
    }

    // Create a toString() method
    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", leftChild=" + left +
                ", rightChild=" + right +
                '}';
    }

    public static void main(String[] args) {
        BinaryNode <Integer> tree = new BinaryNode<>(1, new BinaryNode<>(7), new BinaryNode<>(9));
        tree.getLeft().setLeft(new BinaryNode<>(2));
        tree.getLeft().setRight(new BinaryNode<>(6));
        tree.getLeft().getRight().setLeft(new BinaryNode<>(5));
        tree.getLeft().getRight().setRight(new BinaryNode<>(11));
        tree.getRight().setRight(new BinaryNode<>(9));
        tree.getRight().getRight().setLeft(new BinaryNode<>(5));
//        BinaryNode <Integer> tree = new BinaryNode<>(1, new BinaryNode<>(7, new BinaryNode<>(2), new
//                BinaryNode<>(6, new BinaryNode<>(5), new BinaryNode<>(11))), new BinaryNode<>(9,
//                null, new BinaryNode<>(9, new BinaryNode<>(5), null)));
    }
}
