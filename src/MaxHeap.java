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
        // Check if current node is null after moving to the child node
        if (currentNode == null) {
            return; // No more nodes to traverse
        }

        if (newNode.getData() > currentNode.getData()) {
            // Swap values if new node is greater than current node
            int temp = newNode.getData();
            newNode.setData(currentNode.getData());
            currentNode.setData(temp);
        }

        if (currentNode.getLeft() == null) {
            // If the left child is null, insert the new node as the left child
            currentNode.setLeft(newNode);
        } else if (currentNode.getRight() == null) {
            // If the right child is null, insert the new node as the right child
            currentNode.setRight(newNode);
        } else {
            // Both left and right children exist; compare their depth
            int leftDepth = depth(currentNode.getLeft());
            int rightDepth = depth(currentNode.getRight());

            if (leftDepth <= rightDepth) {
                // Insert into the left child (or subtree)
                insertNode(currentNode.getLeft(), newNode);
            } else {
                // Insert into the right child (or subtree)
                insertNode(currentNode.getRight(), newNode);
            }
        }
    }

    // Balance the max heap
    public int depth(BinaryNode<?> node){
        if(node == null) {
            return 0;
        }

        // Return the number of nodes in the subtree
        return 1 + depth(node.getLeft()) + depth(node.getRight());
    }

    public static void main(String[]args){
        // Create a max heap object
        MaxHeap heap=new MaxHeap();

        // Create a scanner object
        Scanner scanner=new Scanner(System.in);

        // Prompt the user to enter numbers to insert into the max heap
        while(true){
            // Prompt the user to enter a number
            System.out.print("Enter a number to insert into the heap (or -1 to quit): ");
            int data=scanner.nextInt();

            // Check if the user entered -1
            if(data==-1){
                break;
            }

            // Insert the new node into the max heap
            heap.insertNode(new BinaryNode<>(data));

            // Print the max heap after each insertion
            heap.root.postOrderTraversal();
        }

        // Close the scanner
        scanner.close();
    }
}
