import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class lab3_Runner{
	public static void main(String[] args) throws FileNotFoundException{

		String filePath = ("/Users/yarah/onedrive/desktop/cs2/lab3/input.txt");
		File input = new File(filePath);

		Box[] boxArr = new Box[10]; //creates new box array with a size of 10 (will be fixed later).
		int boxArrIndex=0;

		try {
			Scanner inputScanner = new Scanner(input);

			for(int i=0; i<boxArr.length && inputScanner.hasNextLine();i++){ //traverses through file while creating box objects that are then placed into the array. 
				String line = inputScanner.nextLine();
				Scanner lineReader= new Scanner(line);
				double length = lineReader.nextDouble();
				double width = lineReader.nextDouble();
				double height = lineReader.nextDouble();

				boxArr[i] = new Box(length, width, height);

				boxArrIndex++; //used to eventually create a correctly sized array.
			}

	 		inputScanner.close();

	 	} catch (FileNotFoundException e){

			System.out.println("Error in file reading");

			return;
		}

		Box[] finalBoxArr = new Box[boxArrIndex];

		for(int j=0;j<boxArrIndex;j++){ //creates correctly sized array.
			finalBoxArr[j]=boxArr[j];
		}

		//calling all methods in order:

		Box largest = search4Largest(finalBoxArr);

		double average = avgSA(finalBoxArr);

		printInfo(largest, average, finalBoxArr);
	
	}

	public static Box search4Largest(Box[] arr){
		Box largestBox = arr[0];

		for (int i=0;i<arr.length;i++) {
			if(arr[i].getSurfaceArea()>largestBox.getSurfaceArea()){ //checks if the box at i is greater than the avg.
				largestBox=arr[i];
			}
		}
		return largestBox;
	}


	public static double avgSA(Box[] arr){
		double sumArea=0;
		int numBoxes = arr.length;
		for (int i=0; i<arr.length; i++) {	
			sumArea+=arr[i].getSurfaceArea();
		}

		double finalAvg = sumArea/numBoxes;

		return finalAvg;

	}

	public static void printInfo(Box largest, double avgSA, Box[] arr){
		System.out.println("Average surface area: "+avgSA);
		System.out.print("Box Indices larger than average surface area: ");
		for(int i=0;i<arr.length;i++){
			if(arr[i].getSurfaceArea()>avgSA){
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.print("The largest box has index: ");
		int largestIndex=0;
		for(int i=0;i<arr.length;i++){
			if(largest==arr[i]){
				largestIndex=i;
			}
		}
		System.out.print(largestIndex+", surface area: "+arr[largestIndex].getSurfaceArea()+", and dimensions: ");
		System.out.println("length: "+arr[largestIndex].getLength()+", width: "+arr[largestIndex].getWidth()+", and height: "+arr[largestIndex].getHeight());


		int countLarge=0;
		int countSmall=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].getSurfaceArea()>avgSA){
				countLarge++;
			} else if(arr[i].getSurfaceArea()<avgSA){
				countSmall++;
			}

		}
		System.out.println("Number of boxes with larger than average surface area: "+countLarge);
		System.out.println("Number of boxes with smaller than average surface area: "+countSmall);

	}


}