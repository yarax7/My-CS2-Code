public class lab8_Salamah {
    public static void main(String[] args) {
        // Test Bubble Sort
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("---------------");
        printIntArray("Before Sorting", arr1);
        bubbleSort(arr1);
        printIntArray("Bubble Sort", arr1);
        System.out.println("---------------");

        // Test Selection Sort
        // Sample array containing student names and grades
        String[][] studentData = {
                {"John", "85"},
                {"Alice", "72"},
                {"Bob", "90"},
                {"Charlie", "68"},
                {"Diana", "77"}
        };
        printStringArray("Before Sorting", studentData);
        sortByGradeSelectionSort(studentData);
        printStringArray("Selection Sorting", studentData);
        System.out.println("---------------");

        // Test Insertion Sort
        String[] arr3 = {"John", "Alice", "Bob", "Charlie", "Diana"};
        printStringArray("Before Sorting", arr3);
        insertionSortNames(arr3);
        printStringArray("Insertion Sort", arr3);
        System.out.println("---------------");

        // Test Merge Sort
        double[] arr4 = {64.5, 34.2, 25.1, 12.8, -22.7, -11.3, 90.6};
        printDoubleArray("Before Sorting", arr4);
        mergeSortDescending(arr4);
        printDoubleArray("Merge Sort", arr4);
        System.out.println("---------------");

        // Test Quick Sort
        String[] arr5 = {"2023-04-15", "2022-11-30", "2024-01-01", "2023-09-20", "2022-07-05"};
        printStringArray("Before Sorting", arr5);
        quickSortDates(arr5, 0, arr5.length - 1);
        printStringArray("Quick Sort", arr5);
        System.out.println("---------------");
    }

    // Bubble Sort Implementation
    /**
    * Change the body of this method to sort the array of integers using the Bubble Sort algorithm.
    * 
    * @param arr The array of integers to be sorted.
    */
    public static void bubbleSort(int[] arr) {
       int n=arr.length;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                //compares the two values next to each other in the array and swaps accordingly:
                if(arr[j-1]>arr[j]){
                    //swap:
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    // Selection Sort Implementation for sorting student data by grade
    /**
    * Change the body of this method to sort the array of student data based on grades using the Selection Sort algorithm.
    * 
    * @param arr The 2D array containing student names and grades.
    */
    public static void sortByGradeSelectionSort(String[][] arr) {
        for(int i=0;i<arr.length-1;i++){
            //initialized minIndex here because it will change throughout interations:
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                //converts string values to ints in order to compare them later:
                int x = Integer.parseInt(arr[minIndex][1]);
                int y = Integer.parseInt(arr[j][1]);
                if(x>y){
                    //checks which grade is greater
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                //re-sorts names and grades accordingly:
                String[] temp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
            }
        }
        
    }


    // Insertion Sort Implementation for String array
    /**
    * Change the body of this method to sort the array of strings using the Insertion Sort algorithm.
    * 
    * @param arr The array of strings to be sorted.
    */
    public static void insertionSortNames(String[] arr) {
        //initializing variables:
         int j;
         String key;
         int i;

         for(j=1;j<arr.length;j++){
            key=arr[j];
            for(i=j-1; (i>=0)&&(arr[i].compareTo(key)>0);i--){
                //checks if the first letter is of lesser value than the second word's first letter:
                arr[i+1]=arr[i];
            }
            arr[i+1]=key;
         } 
    }

    // Merge Sort Implementation for double array in descending order
    /**
    * Change the body of this method to sort the array of doubles in descending order using the Merge Sort algorithm.
    * 
    * @param arr The array of doubles to be sorted.
    */
    public static void mergeSortDescending(double[] arr) {
        if(arr.length>1){
            //mid index:
            int mid=arr.length/2;
            //creating two smaller arrays:
            double[] low=new double[mid];
            double[] high=new double[arr.length-mid];


            //Assigning our two new arrays the values from the original arr.
            for(int i=0;i<mid;i++){
                low[i]=arr[i];
            }

            for(int i=mid;i<arr.length;i++){
                high[i-mid]=arr[i];
            }

            //sorting our two smaller []'s:
            mergeSortDescending(low);
            mergeSortDescending(high);


            //merging the two smaller sorted arrays.
            int i=0;
            int j=0;
            int y=0;
            while(i<low.length && j<high.length){
                if(low[i]>=high[j]){
                    arr[y++]=low[i++];
                } else {
                    arr[y++]=high[j++];
                }
            }

            //catching any leftover values from low[].
            while(i<low.length){
                arr[y++]=low[i++];
            }

            //same with high[].
            while(j<high.length){
                arr[y++]=high[j++];
            }
        }
        
    }

    // Quick Sort Implementation for dates in ascending order
    /**
    * Change the body of this method to sort the array of strings representing dates in ascending order using the Quick Sort algorithm.
    * 
    * @param arr The array of strings representing dates to be sorted.
    * @param low The index of the first element in the array.
    * @param high The index of the last element in the array.
    * @return The partition index.
    */
    public static void quickSortDates(String[] arr, int low, int high) {
        //checks if low is lesser than high:
        if(low<high){
            int partitionIndex= quickSortHelper(arr, low, high);

            //sorts the arrays recursively:
            quickSortDates(arr, low, partitionIndex-1);
            quickSortDates(arr, partitionIndex+1,high);
        }
    }

    public static int quickSortHelper(String[] arr , int low, int high){
        //assigns different values to different variables in order to make comparing easier.
        int pivotYear=Integer.parseInt(arr[high].substring(0,4));
        int pivotMonth=Integer.parseInt(arr[high].substring(5,7));
        int pivotDay=Integer.parseInt(arr[high].substring(8));

        //index:
        int i=low-1;

        for(int j=low;j<=high-1;j++){
            //assigns different values to different variables in order to make comparing easier.
            int yearAtJ=Integer.parseInt(arr[j].substring(0,4));
            int monthAtJ=Integer.parseInt(arr[j].substring(5,7));
            int dayAtJ=Integer.parseInt(arr[j].substring(8));
            //checks if year is lesser or greater than the pivot:
            if(yearAtJ<pivotYear){
                i++;
                swap(arr, i, j);
            } else if(yearAtJ==pivotYear){
                //checks if month is lesser or greater than the pivot (in case they are in the same year):
                if(monthAtJ<pivotMonth){
                    i++;
                    swap(arr, i, j);
                } else if(dayAtJ<pivotDay){
                    //checks if day is lesser or greater than the pivot (in case they are in the same month):
                    i++;
                    swap(arr, i, j);
                }
            }
        }
        swap(arr,i+1,high);
        return(i+1);
    }

    public static void swap(String[] arr, int i, int j){
        //helper method
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    // Utility method to print an integer array
    public static void printIntArray(String sortName, int[] arr) {
        System.out.print(sortName + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method to print a string array
    public static void printStringArray(String sortName, String[] arr) {
        System.out.print(sortName + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method to print a double array
    public static void printDoubleArray(String sortName, double[] arr) {
        System.out.print(sortName + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method to print a 2D string array
    public static void printStringArray(String title, String[][] arr) {
        System.out.println(title + ":");
        for (String[] row : arr) {
            System.out.println("Name: " + row[0] + ", Grade: " + row[1]);
        }
        System.out.println();
    }
}