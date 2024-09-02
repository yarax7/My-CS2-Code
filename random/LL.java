public class LL{
   public static void main(String[] args){
      Node a = new Node(10);
      Node b = new Node(5);
      Node c = new Node(7);
      Node d = new Node(15);

      a.next=b;
      b.next=c;
      c.next=d;

      printLL(a);
      deleteNode(a, 1);
      System.out.println();
      printLL(a);
      // printLL(deleteNode(a,0)); //This is the only way I was able to get it to work for position 0.


   }


   public static void printLL(Node head){
      while(head!=null){
         System.out.print(head.getVal()+" ");
         head=head.next;
      }
   }

   public static Node deleteNode (Node head, int position) {
      int count=0;
      if(head==null){
         return null;
      }
      while(head!=null){
         if(position==0){
            head=head.next;
            return head;
         }
         count++;
         if(count==position){
            head.next=head.next.next;
         } else {
            head=head.next;
         }
      }
      return head;
   }
}
