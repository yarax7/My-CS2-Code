public class Review{

	public static void main(String[] args){

		int[] myArray1;
		//when array is not defined (like this^) the only thing 
		//this line of code does is hold the reference or address of where the array is in memory.
		myArray1= new int [5];
		//this line gives the array a size. (still at the same address.)
		System.out.println(myArray1);

		///////////////////////////////////////////////////////////////////////////////////////////////

		int[] myArray2= new int[4];

		///////////////////////////////////////////////////////////////////////////////////////////////

		int[] myArray3= {1, 8, 4000, 13, 21};

		///////////////////////////////////////////////////////////////////////////////////////////////
		//calling method:

		printArray(myArray1);
		System.out.println();
		printArray(myArray2);
		System.out.println();
		printArray(myArray3);

		////////////////////////////
		System.out.println();
		findMax(myArray3);
		////////////////////////////
		int[] yArray= null;
		findMax(yArray);

		int[] zArray= {};
		findMax(zArray);
		///////////////////////////

		//pass-by-value: multiple copies, so if you change something, you can always return to the original copy.
		//(ints are pass by value)
		int value= 50;
		System.out.println("value before method: "+value);
		myMethod_int(value);
		System.out.println("value after method: "+value);
		//pass-by-reference: one copy where all changes can be seen by anyone who sees.
		//(arrays are pass by reference)
		System.out.println(myArray3[2]);
		myMethod_arr(myArray3);
		System.out.println("After the method call: "+myArray3[2]);

		//2D array (jagged and not)
			int[][] aa={
				{1, 10, 3},
				{4, 5, 7, 8, 9},
				{62, 9, 48},
				{10}
			};

			int[][] bb = new int [4][5];

			print2DArray(aa);
		}

	

	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	public static void findMax(int[] arr){
		if(arr==null){
			System.out.println("This array is null");
			return;
		}
		if(arr.length==0){
			System.out.println("This array is empty");
			return;
		}
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		System.out.println("The largest number is: "+ max);
	}

	public static void myMethod_int(int val){
		val+=73;
		System.out.println("within method the value is: "+val);
	} 

	public static void myMethod_arr(int[] arr){
		arr[2]-=1000;
		System.out.println("Within method: "+arr[2]);
	}

	public static void print2DArray(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0; j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}