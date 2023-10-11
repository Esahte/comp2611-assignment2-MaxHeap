public class MaxHeap {
    BinaryNode<Integer> root;

    // Constructor with no parameters
    public MaxHeap() {
        root = null;
    }

    // Constructor with one parameter of type BinaryNode<Integer>
    public MaxHeap(BinaryNode<Integer> root) {
        this.root = root;
    }

    // Insert a new node into the max heap
    public void insertNode(BinaryNode<Integer> newNode) {
        // Check if the root node is null
        if (root == null) {
            root = newNode;
            return;
        }

        // Recursively insert the new node
        insertNode(root, newNode);
    }

    // recursive insertNode
    private void insertNode(BinaryNode<Integer> currentNode, BinaryNode<Integer> newNode) {
        if (newNode.getData() > currentNode.getData()) {
            // Swap the new node with the current node
            int temp = newNode.getData();
            newNode.setData(currentNode.getData());
            currentNode.setData(temp);
        }

        // Count the number of nodes in the left and right subtrees
        int leftHeight = countSubtree(currentNode.getLeft());
        int rightHeight = countSubtree(currentNode.getRight());

        // Move to the child node
        if (leftHeight <= rightHeight) {
            // Insert the new node into the left subtree
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                return;
            }
            currentNode = currentNode.getLeft();
        } else {
            // Insert the new node into the right subtree
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                return;
            }
            currentNode = currentNode.getRight();
        }

        // Check if current node is null after moving to the child node
        if (currentNode == null) {
            return; // No more nodes to traverse
        }

        // Recursively insert the new node
        insertNode(currentNode, newNode);
    }

    // Balance the max heap
    public int countSubtree(BinaryNode<?> node){
        if(node == null) {
            return 0;
        }

        // Return the number of nodes in the subtree
        return 1 + countSubtree(node.getLeft()) + countSubtree(node.getRight());
    }
}
