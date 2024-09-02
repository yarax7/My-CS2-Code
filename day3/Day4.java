public class Day4{
	public static void main(String[] args){
		System.out.println("2D Array: ");
		int [][] aa={
			{1, 3, 5},
			{2, 4, 6},
			{7, 8, 9}
		};
		addRows(aa);
		System.out.println("/////////////////////////////////");
		add2DColumns(aa);
		System.out.println("/////////////////////////////////");
		printD(aa);

		System.out.println("Array of Objects: ");
		Circle[] myCircles=new Circle[5];
		for(int i=0;i<myCircles.length;i++){
			myCircles[i]= new Circle(i+1);
		}
		for(int i=0;i<myCircles.length;i++){
		System.out.println(myCircles[2].getRadius());
		}

		//static variable:

		Box b1= new Box();
		System.out.println(b1.height);
		Box b2 = new Box{2, 3, 4};

		System.out.println(b1.height);
		System.out.println(b2.height);
		
	}

	public static void addRows(int [][] arr){
		int add=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				add+=arr[i][j];
			}
			System.out.println(add);
			add=0;
		}
	}

	public static void add2DColumns(int [][] arr){
		int add=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				add+=arr[j][i];
			}
			System.out.println(add);
			add=0;
		}
	}

	public static void printD(int [][] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i][i]);
		}
	}
}