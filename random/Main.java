public class LL{
   public static void main(String[] args){

   }












   public static Node deleteNode (Node head, int position) {
      int count=0;
      while(head!=null){
         count++;
         if(count==position){
            head=head.next.next;
         } else {
            head=head.next;
         }
      }
   }
}