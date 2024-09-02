public class feb29{
    public static void main(String[] args){
        Node a= new Node(29);
        Node b= new Node(20);
        Node c= new Node(10);

        a.next=b;
        b.next=c;

        System.out.println(countOdd(a));

        char one = 'b';
        char two = (char) (one+2);
        System.out.println(two);
    }

    public static int countOdd(Node head) {
        if(head==null){
            return 0;
        }
        if(head.data%2==1){
            return 1+countOdd(head.next);
        } else {
            return countOdd(head.next);
        }
    }
}