import java.io.File;
import java.util.Scanner;

class Lab2_Salamah{
	static int[][] correct_times_table = new int[12][12];

	public static void main(String[] args){	
		createTimesTable(correct_times_table);
		int rowToCheck = -1;
  		int columnToCheck = -1; 
		
		int[][] input_times_table = new int [12][12];
		try{
	    	File file = new File("input.txt");
		    Scanner sc = new Scanner(file);
		    int i=0;
		    String str = sc.nextLine();
		    Scanner scan = new Scanner(str);
		    rowToCheck = scan.nextInt();
		    
		    str = sc.nextLine();
		    scan = new Scanner(str);
		    columnToCheck = scan.nextInt();
		    
		    while(sc.hasNextLine()){
		    	str = sc.nextLine();
		    	scan = new Scanner(str);

		      	for(int j=0; j<12; j++){
        			input_times_table[i][j] = scan.nextInt();	
        		}	
        		i++;
			}
		}catch (Exception e){

      System.out.println("Error occured during file reading.");
  	}
  	//print2DArray(input_times_table);
  	
  	checkMistake(input_times_table);
  	
  	boolean correct = checkRow(input_times_table, rowToCheck-1);
  	if(correct)
  		System.out.println("Row "+rowToCheck+ " is correct.");
  	else
  		System.out.println("Row "+rowToCheck+ " is incorrect.");
  	
  	correct = checkColumn(input_times_table, columnToCheck-1);
  	if(correct)
  		System.out.println("Column "+columnToCheck+ " is correct.");
  	else
  		System.out.println("Column "+columnToCheck+ " is incorrect.");
  	
  	printTriangle(input_times_table);
}

	public static void print2DArray(int[][] arr){
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col]+ " ");
			}
		System.out.println();
		}
	}

	public static void createTimesTable(int[][] arr){
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				arr[row][col] = (row+1)*(col+1);
			}
		}
	}

	public static void checkMistake(int[][] b){
		int incorrect = 0;
		//incorrect is used as a counter in this method.
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
				//nested for loops to traverse the entire array.
				int row=i+1;
				int col=j+1;
				//i created these row and col variables in order to not get confused between row/col values that start at 1 instead of 0.
				if(correct_times_table[i][j]!=b[i][j]){
					incorrect++;
					System.out.println("Row "+ row +", column "+ col +": "+ b[i][j]+" should be "+ correct_times_table[i][j]);
				}
			}
		}
		System.out.println("The total number of mistakes: "+incorrect);
	}


	public static boolean checkRow(int[][] b, int row){
		for(int j=0;j<b.length;j++){
			//since we are only traversing through the rows, only one for loop is needed.
			if(b[row][j]!=correct_times_table[row][j]){
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkColumn(int[][] b, int col){
		for(int i=0;i<b.length;i++){
			if(b[i][col]!=correct_times_table[i][col]){
			//same as before, since we are only traversing through the columns, we only need one for loop, we just have to switch the order of the index's when checking rows and checking columns.
				return false;
			}
		}
		return true;
	}

	public static void printTriangle(int[][] a){
		System.out.println("The lower triangle is: ");
		int count=1;
		//count is a variable i created that will be +1 everytime the first for loop interates in order to use it as the condition for my second for loop.
		for(int i=0;i<a.length;i++){
			for(int j=0;j<count;j++){
				//nested for loops to traverse the entire array.
				System.out.print(a[i][j]+" ");
			}
			if(count!=a.length){
					count++;
				}
			System.out.println();
			//this print line is what starts a new line for each multiple in the times table, if it was not here, the "triangle" would print as a line.
		}
	}
}

