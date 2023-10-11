import java.util.Scanner;


public class Main {
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

