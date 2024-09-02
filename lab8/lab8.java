public class lab8 {
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
        // Your implementation here
        
    }


    // Insertion Sort Implementation for String array
    /**
    * Change the body of this method to sort the array of strings using the Insertion Sort algorithm.
    * 
    * @param arr The array of strings to be sorted.
    */
    public static void insertionSortNames(String[] arr) {
        // Your implementation here
       
    }

    // Merge Sort Implementation for double array in descending order
    /**
    * Change the body of this method to sort the array of doubles in descending order using the Merge Sort algorithm.
    * 
    * @param arr The array of doubles to be sorted.
    */
    public static void mergeSortDescending(double[] arr) {
        // Your implementation here
        
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
        // Your implementation here
        return -1; // Placeholder, replace with the actual return value
        
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
}-



