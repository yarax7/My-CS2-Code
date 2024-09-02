class Circle{
	
	private double radius;
	int[] nums= new int[100];

	Circle next;

	
	Circle(){
		System.out.println("A new object");
	}

	Circle(double radius){
		this.radius=radius;
	}

	double getRadius(){

		return radius;
	}

	void setRadius(double r){
		radius = r;
	}

	void printArea(){
		System.out.println("The area is: "+ 3.14*radius);
	
	}

	void anotherMethod(){
		printArea();
		System.out.println("Within another method: "+radius);
	}

}