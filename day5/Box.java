class Box{
	double length;
	double width;
	static double height;
	static Circle c1;

	Box(){

	}

	Box(double l, double w, double h){
		length =l;
		width= w;
		height=h;
	}

	public double getValue(){
		return length+width+height;
	}

	public static void tester(){
		System.out.println("I am a static method.");
		System.out.println("My static height is: "+height);
	}
}