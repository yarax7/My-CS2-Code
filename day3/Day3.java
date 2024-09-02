public class Day3{

	public static void main(String[] args){

		// int[][] cc = new int[5][6];
		// for(int row=0;row<cc.length;row++){
		// 	for(int col=0;col<cc[row].length;col++){
		// 		System.out.print(cc[row][col]+" ");
		// 	}
		// 	System.out.println();
		// }

		int [][] dd = new int[5][];
		for(int i=0;i<dd.length;i++){
			dd[i]= new int[i+1];
		}

		for(int row=0;row<dd.length;row++){
			for(int col=0;col<dd[row].length;col++){
				System.out.print(dd[row][col]+" ");
			}
			System.out.println();
		}

		//classes and objects

		int i;
		Circle c1= new Circle();
		// System.out.println(c1);
		System.out.println(c1.getRadius());
		c1.printArea();

		Circle c2= new Circle(14.5);
		System.out.println(c2.getRadius());
		c2.printArea();
		c2.anotherMethod();

		myMethod(c1);
		c1.anotherMethod();
	}

	static void myMethod(Circle obj){
		 obj.setRadius(200.3);
	}

}