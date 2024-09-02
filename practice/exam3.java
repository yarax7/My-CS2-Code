class exam3{
    public static void main(String[] args) {
        TreeNode t= new TreeNode(6);
        t.leftChild = new TreeNode(4);
        t.rightChild = new TreeNode(17);
        t.leftChild.rightChild = new TreeNode(5);
        t.rightChild.leftChild = new TreeNode(7);
        t.rightChild.rightChild = new TreeNode(19);
        t.rightChild.rightChild.rightChild = new TreeNode(20);
        t.rightChild.rightChild.leftChild = new TreeNode(18);

        System.out.println(sumOfTwoChildNodes(t));

        System.out.println(countOddLeaves(t));
    }

    static int sumOfTwoChildNodes(TreeNode root){
        if(root.rightChild==null || root.leftChild==null){
            return 0;
        } else {
            return root.item + sumOfTwoChildNodes(root.rightChild) + sumOfTwoChildNodes(root.leftChild);
        }
    }
    static int countOddLeaves(TreeNode root){
         if(root==null){ 
            return 0;
        } else if((root.rightChild==null && root.leftChild==null) && root.item%2==1 ){ 
            return 1+countOddLeaves(root.rightChild)+countOddLeaves(root.leftChild);
        } else {
            return countOddLeaves(root.rightChild)+countOddLeaves(root.leftChild); 
        }
    }
}