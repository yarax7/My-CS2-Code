class April2{
    public static void main(String[] args){
        TreeNode t = new TreeNode(1);
        t.leftChild = new TreeNode(2);
        t.rightChild = new TreeNode(3);
        TreeNode t1 = t.leftChild;
        TreeNode t2 = t.rightChild;
        t1.leftChild = new TreeNode(4);
        t1.rightChild = new TreeNode(5);

        printPreorder(t);
        swapTree(t);
        System.out.println();
        printPreorder(t);
    }

    public static int countNodesInRange(BTNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.data >= low && root.data <= high) {
            return 1 + countNodesInRange(root.left, low, high) + countNodesInRange(root.right, low, high);
        }
        else if (root.data < low) {
            return countNodesInRange(root.right, low, high);
        }
        else {
            return countNodesInRange(root.left, low, high);
        }
    }

    public static void swapTree(TreeNode node){
        if(node.leftChild==null && node.rightChild==null){
            return;
        } 
        TreeNode temp=node.leftChild;
        node.leftChild=node.rightChild;
        node.rightChild=temp;

        swapTree(node.leftChild);
        swapTree(node.rightChild);

    }

    public static void printPreorder(TreeNode T){
        if (T != null) {
            System.out.print(T.item+" ");
            printPreorder(T.leftChild);
            printPreorder(T.rightChild);
	    }

    }
}