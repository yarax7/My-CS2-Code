class April11{
    public static void main(String[] args){
        BTNode t = new BTNode(1);
        t.left = new BTNode(2);
        t.right = new BTNode(3);
        BTNode t1 = t.left;
        BTNode t2 = t.right;
        t1.left = new BTNode(4);
        t1.right = new BTNode(5);

        printExceptLeaves(t);
    }
    
    public static void printExceptLeaves(BTNode root){
        if(root.right == null && root.left == null){
            return;
        } else {
            System.out.print(root.data+" ");
            printExceptLeaves(root.right);
            printExceptLeaves(root.left);
        }
    }
}