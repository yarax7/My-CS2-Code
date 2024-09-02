 class exam2{
    public static void main(String[] args){
        Node a= new Node(7);
        Node b= new Node(22);
        Node c= new Node(4);
        Node d= new Node(87);
        Node e= new Node(72);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        System.out.println("Odds: "+countOdds(a));

        StrNode f= new StrNode("Yara");
        StrNode g= new StrNode("Salamah");
        StrNode h= new StrNode("Mika");
        StrNode i= new StrNode("Zaid");
        StrNode j= new StrNode("Yaffa");
        StrNode k= new StrNode("Jude");

        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=k;

        System.out.println("Num of strings w even length: "+countEvenLengthStrings(f));

        System.out.println("Reverse vowels: "+getRevSemiVowels("SnoWyDaYFewDew"));
    }

    static int countOdds(Node head){
        if(head==null){

            return 0;

        } else if(head.data%2==1){

            return 1+ countOdds(head.next);
        }

        return countOdds(head.next);
    }

     static int countEvenLengthStrings(StrNode head){
        if(head==null){
            return 0;
        } else if(head.data.length()%2==0){
            return 1+ countEvenLengthStrings(head.next);
        }
        return countEvenLengthStrings(head.next);
     }

     static String getRevSemiVowels(String given){
        if(given.length()==0){
            return " ";
        } else if(given.charAt(0)=='w' || given.charAt(0)=='W' || given.charAt(0)=='y' || given.charAt(0)=='Y'){
            char rev = given.charAt(0);
            return getRevSemiVowels(given.substring(1)) + rev;
        }

        return getRevSemiVowels(given.substring(1));
     }
}