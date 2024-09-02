import java.util.Scanner;

public class lab5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test sumDigits methods
        System.out.print("Enter a number for sumDigits: ");
        int num1 = scanner.nextInt();
        System.out.println("Sum of digits (Iterative): " + sumDigitsIterative(num1));
        System.out.println("Sum of digits (Recursive): " + sumDigitsRecursive(num1));

        // Test reverseString methods
        System.out.print("Enter a string for reverseString: ");
        String str = scanner.next();
        System.out.println("Reverse String (Iterative): " + reverseStringIterative(str));
        System.out.println("Reverse String (Recursive): " + reverseStringRecursive(str));

        // Test printTriangle methods
        System.out.print("Enter the number of rows for the triangle: ");
        int rows = scanner.nextInt();
        System.out.println("Triangle (Iterative):");
        printTriangleIterative(rows);

        System.out.println("Triangle (Recursive):");
        printTriangleRecursive(rows, 0);

        // Close the scanner
        scanner.close();
    }

    /**
     * Computes the sum of digits in a number iteratively.
     * @param n The input number.
     * @return The sum of digits in the number.
     */
    public static int sumDigitsIterative(int n) {
        int sum=0; //Initializing the sum variable outside of the loop in order to return in later.
        while(n>0){ 
            sum+=n%10; //Gives the right digit.
            n/=10; //Decrements n to everything except the right digit.
        }
        return sum;
    }

    /**
     * Computes the sum of digits in a number recursively.
     * @param n The input number.
     * @return The sum of digits in the number.
     */
    public static int sumDigitsRecursive(int n) {
        int right=0;
        int sum=0;
        if(n==0){ //Base case.
            return sum;
        }
        right = n%10; //Gives the right digit.
        sum+=right;
        return sum + sumDigitsRecursive(n/10); //Decrements n to everything except the right digit and returns the sum count.
    }

    /**
     * Reverses a string iteratively.
     * @param s The input string.
     * @return The reversed string.
     */
    public static String reverseStringIterative(String s) {
        int i=s.length()-1; //i is used as our index.
        String newString="";
        while(i>=0){
            newString += s.charAt(i); //creates a new string starting from the end of the original string.
            i--; //changes index.
        }
        return newString;  
    }

    /**
     * Reverses a string recursively.
     * @param s The input string.
     * @return The reversed string.
     */
    public static String reverseStringRecursive(String s) {
        int numChars=s.length();
        if(numChars==0){ //Base case.
            return "";
        }
        return s.charAt(s.length()-1)+ reverseStringRecursive(s.substring(0, s.length()-1)); //returns a new string starting from the end of the original string and continues traversing.
    }

    /**
     * Prints a triangle pattern iteratively.
     * @param baseSize The number of rows in the triangle.
     */
    public static void printTriangleIterative(int baseSize) {
        for(int i = 0; i<baseSize; i++){ //nested for loops in order to keep track of how many *'s should be printed on each line.
            for(int x = 0; x<=i; x++){
                System.out.print("*");
            }
        System.out.println(); //starts a new line after every interation of the first for loop.
        }
    }

    /**
     * Prints a triangle pattern recursively.
     * @param baseSize The number of rows in the triangle.
     * @param currentRow The current row being processed.
     */
    public static void printTriangleRecursive(int baseSize, int currentRow) {
        if(currentRow>baseSize){ //base case.
            return;
        }
        for(int i=0;i<currentRow;i++){ //traverses through the number of rows in order to print a correct triangle.
            System.out.print("*");
        }
        System.out.println(); //starts a new line after every interation of the for loop.
        printTriangleRecursive(baseSize, currentRow+1); //recursive call that increases the number of *'s on every line.
               
    }
}