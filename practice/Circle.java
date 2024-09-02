class Circle {
	private double radius;

	Circle next;


	Circle(){

	}

	Circle(double r, Circle next){
		this.radius = r;

		this.next = next;
	}

	double getArea(){
		return 3.14*radius*radius;
	}

	// static int countLarger(Circle head, Circle given){
	// 	int count=0;
	// 	while(head!=null){
	// 		if(given.getArea()<head.getArea()){
	// 			count++;
	// 			head=head.next;
	// 		}
	// 	}
	// 	return count;
	// }
}
