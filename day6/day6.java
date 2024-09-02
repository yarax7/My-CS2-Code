class day6{
	public static void main(String[] args){

		System.out.println("Hello World");

		Circle a = new Circle(2);
		Circle b = new Circle(4);
		Circle c = new Circle(9);
		Circle d = new Circle(7);
		Circle e = new Circle(13);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		 //a-> b-> c-> d-> e

		printLL(a);
		System.out.println("------");
		printLL_R(a);
		System.out.println("------");
		a = addLL(a, new Circle(23.8), 3);
		printLL(a);
		System.out.println("------");
		a = removeLL(a, 5);
		System.out.println(countLL(a));
		System.out.println("------");
		System.out.println(sumLL(a));

	}

	public static void printLL(Circle head){
		while(head!=null){
			System.out.println(head.getRadius());
			head = head.next;
		}
	}

	public static void printLL_R(Circle head){
		if(head!=null){
			System.out.println(head.getRadius());
			printLL_R(head.next);
		}
		return;
	}

	public static Circle addLL(Circle head, Circle toAdd, int pos){
		if(head==null){
			return null; //or you could do return toAdd;
		}	
		if(pos==0){
			toAdd.next = head;	
			return toAdd;
		} 
		int index=1;
		Circle previous = head;
		Circle current = head.next;

		while(current!=null){
			if(pos==index){
				previous.next = toAdd;
				toAdd.next = current;
				return head;
			}
			index++;
			previous = current;
			current = current.next;
		}
		if(pos==index){
			previous.next = toAdd;
			return head;
		}

		else {
			System.out.println("Invalid position to add");
			return head; //or return null;
		}
	}

	public static Circle removeLL(Circle head, int pos){
		if(head==null){
			return null;
		}
		if(pos==0){
			return head.next;
		}

		Circle current = head;
		int index=1;

		while(current.next!=null && index<pos){
			current = current.next;
			index++;
		}

		if (current.next!=null) {
			current.next = current.next.next;
			return head;			
		} else {
			System.out.println("invalid position");
		}
			return head;


		return null;
	}

	public static int countLL(Circle head){
		int count=0;
		while(head!=null){
			head = head.next;
			count++;
		}
		return count;
	}

	public static double sumLL(Circle head){
		double sum=0;
		while(head!=null){
			sum+=head.getRadius();
		}
		return sum;
	}
}