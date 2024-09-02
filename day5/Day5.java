class Day5{

	public static void main(String[] args){

	Box.tester();

	Box b1= new Box();
	b1.height=5;
	b1.tester();

	//inheritance concepts

	Painting p1= new Painting();
	p1.price=100;
	System.out.println(p1.getOrigin());
	System.out.println(p1.getPrice());

	//array of objects

	Circle[] myCircles = new Circle[5];
	myCircles[0]= new Circle();
	myCircles[1]= new Circle(3);

	for(int i=0;i<myCircles.length;i++){
		myCircles[i]= new Circle(i+2);
	}

	//linked lists

	Circle c1 = new Circle(10);
	Circle c2 = new Circle(20);
	Circle c3 = new Circle(30);
	Circle c4 = new Circle(40);

	c1.next = c2;
	c2.next = c3;
	c3.next = c4;

	Circle head = c1;

	printLL(head);
	System.out.println();
	System.out.println("//////////////////////////////////////////////////");
	printLL_recursive(head);
	System.out.println();
	System.out.println("//////////////////////////////////////////////////");
	addLL(head);

	}

	public static void printLL(Circle head){
		while(head!=null){
		System.out.print(head.getRadius()+" ");
		head= head.next;
		}
	}

	public static void printLL_recursive(Circle head){
		if(head==null){
			return;
		} else {
			System.out.print(head.getRadius());
		}
		printLL_recursive(head.next);
	}

	public static void addLL(Circle head){
		double sum=0;
		while(head!=null){
		sum+=head.getRadius();
		head= head.next;
		}
		System.out.println(sum);
	}
}