public class lab9_Salamah {
    public static void main(String[] args) {
        TreeNode t = new TreeNode("Ariana" , 20);
        t.leftChild = new TreeNode("Britney", 34);
        t.rightChild = new TreeNode("Camila" , 27);
        TreeNode t1 = t.leftChild;
        TreeNode t2 = t.rightChild;
        t1.leftChild = new TreeNode("Demi" , 37);
        t1.rightChild = new TreeNode("Ellie", 44);
        t2.leftChild = new TreeNode("Fergie", 36);
        t2.rightChild = new TreeNode("Olivia",21);

        System.out.println("Height of the tree: ");
        System.out.println(countHeight(t));

        System.out.println("Number of people older than 30: ");
        System.out.println(countPeopleOlderThan30(t));

        System.out.println("List of Names Starting With Vowel: ");
        printNamesStartingWithVowel(t);

        System.out.println("Number of nodes: ");
        System.out.println(countNodes(t));

        System.out.println("Number of leaves: ");
        System.out.println(countLeaves(t));

        System.out.println("\nPrinting list in Pre-order");
        printPreorder(t);

        System.out.println("\nPrinting list in Post-order");
        printPostorder(t);

        System.out.println("\nPrinting list in Inorder");
        printInorder(t);
    }

    // Calculates the height of the binary tree starting from the given root node.
    public static int countHeight(TreeNode root) {
        if (root == null){ //Base case.
            return 0;
        } else {
            return 1 +  Math.max(countHeight(root.leftChild), countHeight(root.rightChild)); //Finds the greater value of the two.
        }
    }

    // Counts the number of people in the binary tree whose age is greater than 30.
    public static int countPeopleOlderThan30(TreeNode node) {
        if(node.leftChild==null || node.rightChild==null){ //Base case is not root==null because we are checking the children's values (ages).
            return 0;
        } else if(node.leftChild.age>=30 && node.rightChild.age>=30){ //Checks if both children have ages over 30.
            return 2 + countPeopleOlderThan30(node.leftChild) + countPeopleOlderThan30(node.rightChild); 
        } else if(node.leftChild.age>=30 || node.rightChild.age>=30){ //Checks if only one child has an age greater than 30.
            return 1+ countPeopleOlderThan30(node.leftChild) + countPeopleOlderThan30(node.rightChild); 
        } else {
            return countPeopleOlderThan30(node.leftChild) + countPeopleOlderThan30(node.rightChild); //Return if no children are older than 30.
        }
    }

    // Prints the names of people in the binary tree whose names start with a vowel.
    public static void printNamesStartingWithVowel(TreeNode node) {
        if(node==null){ //Base case.
            return;
        } else if(node.name.charAt(0)=='A' || node.name.charAt(0)=='E' || node.name.charAt(0)=='I' || node.name.charAt(0)=='O' || node.name.charAt(0)=='U'){ //Checks for vowel starting names.
            System.out.println(node.name);
        }
        //Recursive call that will be used in all cases (vowel names or not).
        printNamesStartingWithVowel(node.leftChild);
        printNamesStartingWithVowel(node.rightChild);
    
    }


    // Counts the total number of nodes in the binary tree.
    public static int countNodes(TreeNode node) {
        if(node==null){ //Base case.
            return 0;
        } 
        return 1+ countNodes(node.leftChild) + countNodes(node.rightChild); //Counter that counts all nodes in the tree.
    }

    // Counts the number of leaf nodes in the binary tree.
    public static int countLeaves(TreeNode node) {
        if(node==null){ //Base case.
            return 0;
        } else if(node.rightChild==null && node.leftChild==null){ //Checks if the node is a leaf or not and counts it.
            return 1+countLeaves(node.rightChild)+countLeaves(node.leftChild);
        } else {
            return countLeaves(node.rightChild)+countLeaves(node.leftChild); //Continues traversing without counting if the node is not a leaf.
        }
    }

    // Prints the nodes of the binary tree in pre-order traversal (Root, Left, Right).
    public static void printPreorder(TreeNode T){
        if (T != null) { //Base case.
            T.printNode(); //Prints
            //Traverses:
            printPreorder(T.leftChild);
            printPreorder(T.rightChild);
	    }

    }

    // Prints the nodes of the binary tree in post-order traversal (Left, Right, Root).
    public static void printPostorder(TreeNode T){
        if (T != null) { //Base case
            //Traverses:
            printPostorder(T.leftChild);
            printPostorder(T.rightChild);
            T.printNode(); //Prints
        }

    }

    // Prints the nodes of the binary tree in post-order traversal (Left, Right, Root).
    public static void printInorder(TreeNode T){
        if (T != null) { //Base case
            printInorder(T.leftChild); //Traverses
            T.printNode(); //Prints
            printInorder(T.rightChild); //Traverses
	    }
    }

}