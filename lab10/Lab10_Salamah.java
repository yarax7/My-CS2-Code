public class Lab10_Salamah {

    public static void main(String[] args) {
        // Create two binary trees
        BTNode root1 = createTree1();
        BTNode root2 = createTree2();
    
        // Sum of K Largest Elements
        // Test 1
        int k = 13;
        int sumOfKLargest1 = sumKLargest(root1, k);
        System.out.println("****************************************************************");
        System.out.println("Method: Sum of elements bigger or equal than k");
        System.out.println("Sum of elements larger than "+ k +" for tree1: " + sumOfKLargest1);
        // Test 2
        k = 25;
        int sumOfKLargest2 = sumKLargest(root2, k);
        System.out.println("Sum of elements larger than "+ k +" for tree2: " + sumOfKLargest2);
        System.out.println("");
        System.out.println("****************************************************************");
    
    
        // Group 2: Minimum Difference
        // Test 1
        int minDiff1 = minDifference(root1);
        System.out.println("\nMethod: Minimum Difference");
        System.out.println("Minimum absolute difference between any two nodes for Tree 1: " + minDiff1);
        // Test 2
        int minDiff2 = minDifference(root2);
        System.out.println("Minimum absolute difference between any two nodes for Tree 2: " + minDiff2);
        System.out.println("");
        System.out.println("****************************************************************");
    
    
        // Group 3: Truncate BST
        // Test 1
        int sumThreshold = 20; 
        BTNode truncatedBST1 = truncateBST(root1, sumThreshold);
        System.out.println("\nMethod: Truncate BST");
        System.out.println("Inorder traversal of truncated BST 1:");
        printInOrder(truncatedBST1);
        // Test 2
        sumThreshold = 50;
        BTNode truncatedBST2 = truncateBST(root2, sumThreshold);
        System.out.println("\nInorder traversal of truncated BST 2:");
        printInOrder(truncatedBST2);
        System.out.println("\n");
        System.out.println("****************************************************************");
    
        // Group 4: Insert Kth Sum
        // Restore the trees
        root1 = createTree1();                
        root2 = createTree2();
        // Test 1
        k = 4;
        BTNode updatedRoot1 = insertKSum(root1, k);
        System.out.println("\nMethod: Insert Kth Sum");
        System.out.println("Inorder traversal after inserting sum of first " + k + " elements for Tree1:");
        printInOrder(updatedRoot1);
        // Test 2
        k = 5;
        BTNode updatedRoot2 = insertKSum(root2, k);
        System.out.println("\nInorder traversal after inserting sum of first " + k + " elements Tree2:");
        printInOrder(updatedRoot2);
        System.out.println("\n");
        System.out.println("****************************************************************");
        System.out.println("\n");
    }
    
    //SumKLargest returns an int equal to the sum of all the values larger than a given k
    public static int sumKLargest(BTNode root, int k) {
        if(root==null){ //Base case.
            return 0;
        } else if(root.data>=k){ //Checks if the data is greater than k.
            return root.data + sumKLargest(root.right,k) + sumKLargest(root.left,k); //Adds the value to the int that will be returned.
        }
        return sumKLargest(root.right,k)+sumKLargest(root.left,k); //Other recursive call.
    }



    /*minDifference returns an int equal to the minimum difference of any two nodes of
    the given binary search tree*/
    public static int minDifference(BTNode root) {
        int left = Integer.MAX_VALUE; // sets left to maximum value
        int right = Integer.MAX_VALUE; // sets right to maximum value

        //Left:
        if (root.left != null) {
            int min = root.data - root.left.data; // Finds the difference in the left subtree.
            int minLeft = minDifference(root.left); // Finds the minimum difference in left subtree
            if (minLeft < min) { 
                min = minLeft;
            }
            left = min;
        }

        //Right:
        if (root.right != null) {
            int min = root.right.data - root.data; // Finds the difference in the right subtree.
            int minRight = minDifference(root.right); // Finds the minimum difference in right subtree
            if (minRight < min) { 
                min = minRight;
            }
            right = min;
        }
        return Math.min(left, right); //returns the min.
    }
         


    /*truncateBST removes the nodes which the sum
    of its full path is less than a given k and returns the root of the BST*/
    public static BTNode truncateBST(BTNode root, int k) {
        if (root == null) { //Base case
            return null; 
        }
        root.left = truncateBST(root.left, k - root.data);
        root.right = truncateBST(root.right, k - root.data);
        // Check if the current node is a leaf.
        if (isALeaf(root) && k > root.data) {
            root = null; // Remove the leaf node if its data is greater than k
        }
        return root; // Return the modified root of the BST
    }

     public static boolean isALeaf(BTNode root) { //Helper method.
        return root != null && root.left == null && root.right == null;
    }


    /*insertKSum inserts a BTNode with a value equal to the sum of the first k elements
    and returns the root of the BST*/
        public static BTNode insertKSum(BTNode root, int k) {
        if (root == null || k <= 0) { //Base case
            return root;
        }
        //Initializing sum and count variables:
        int sum = 0;
        int count = 0;
        // Traversing:
        root = inOrder(root, k, sum, count);
        //Creating a new node to insert later.
        BTNode newNode = new BTNode(sum);
        root = insertNode(root, newNode);
        return root;
    }

    public static BTNode insertNode(BTNode root, BTNode newNode) { //Helper method
        if (root == null) { //Base case:
            return newNode; 
        }
        //Puts lesser nodes into the left tree:
        if (newNode.data < root.data) {
            root.left = insertNode(root.left, newNode);
        } 
        // Puts greater nodes into the right tree:
        else if (newNode.data > root.data) {
            root.right = insertNode(root.right, newNode);
        }
        return root;
    }

    public static BTNode inOrder(BTNode root, int k, int sum, int count) { 
        if (root == null) { //Base case
            return null;
        }
        // Traversing:
        root.left = inOrder(root.left, k, sum, count);
        if (count < k) {
            sum += root.data;
            count++;
        }
        // Traversing:
        root.right = inOrder(root.right, k, sum, count);
        return root;
    }

//********************Ignore everything below this line******************** 

    //Helper method to create the first BST
    private static BTNode createTree1() {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(15);
        root.left.left = new BTNode(3);
        root.left.right = new BTNode(7);
        root.right.left = new BTNode(12);
        root.right.right = new BTNode(17);
        return root;
    }

    // Helper method to create the second BST
    private static BTNode createTree2() {
        BTNode root = new BTNode(20);
        root.left = new BTNode(10);
        root.right = new BTNode(30);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(13);
        root.right.left = new BTNode(25);
        root.right.right = new BTNode(35);
        root.left.left.left = new BTNode(1);
        root.left.left.right = new BTNode(7);
        root.left.right.left = new BTNode(12);
        root.left.right.right = new BTNode(17);
        root.right.left.left = new BTNode(22);
        return root;
    }

    // Helper method to print the inorder traversal of the BST
    private static void printInOrder(BTNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }


}