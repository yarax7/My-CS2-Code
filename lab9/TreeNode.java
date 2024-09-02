public class TreeNode{
    public String name;
    public int age;

    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode (String newName, int newAge) {
        name = newName;
        age = newAge;
        leftChild = null;
        rightChild = null;
    }

    public TreeNode (String newName, int newAge, TreeNode l,
                     TreeNode r) {
        name = newName;
        age = newAge;
        leftChild = l;
        rightChild = r;
    }

    public void printNode() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}