import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab_3Runner3 {
    public static void main(String[] args) {
        // Create a File object to represent the input file
        File file = new File("input2.txt");
       
        // Create an array to store Box objects
        Box[] boxes = new Box[8]; // Assuming a maximum of 8 boxes
        int positionArr = 0; // Track the current position in the array

        try {
            // Create a Scanner to read from the input file
            Scanner scanner = new Scanner(file);
           
            // Read box dimensions from the file until there are no more lines or array is full
            for (int i = 0; scanner.hasNextLine() && i < boxes.length; i++) {
                String line = scanner.nextLine(); // Read a line from the file
                Scanner lineReader = new Scanner(line); // Create a Scanner to read the line
                lineReader.useDelimiter(" "); // Set delimiter to space
               
                // Read dimensions for each box
                double length = Double.parseDouble(lineReader.next());
                double width = Double.parseDouble(lineReader.next());
                double height = Double.parseDouble(lineReader.next());
               
                // Create Box object and store it in the array
                boxes[i] = new Box(length, width, height);
                positionArr++; // Move to the next position in the array
            }
            scanner.close(); // Close the scanner after reading
        } catch (FileNotFoundException e) { // Catch block for file not found exception
            System.err.println("Error: File 'input2.txt' not found.");
            return; // Exit the program if the file is not found.
        }

        // Filter out any null elements if fewer than 8 boxes were read
        Box[] actualBoxes = new Box[positionArr];
        for (int i = 0; i < positionArr; i++) {
            actualBoxes[i] = boxes[i];
        }

        // Compute average surface area
        double averageSurfaceArea = computeAverageSurfaceArea(actualBoxes);

        // Find the largest Box
        Box largestBox = findLargestBox(actualBoxes);

        // Report various information
        reportInformation(averageSurfaceArea, actualBoxes, largestBox);
    }

    // Method to compute average surface area of all Box objects
    public static double computeAverageSurfaceArea(Box[] boxes) {
        double totalSurfaceArea = 0;

        for (int i = 0; i < boxes.length; i++) {
            totalSurfaceArea += boxes[i].getSurfaceArea();
        }

        return totalSurfaceArea / boxes.length;
    }

    // Method to find the largest Box based on surface area
    public static Box findLargestBox(Box[] boxes) {
        Box largestBox = boxes[0];

        for (int i = 1; i < boxes.length; i++) {
            if (boxes[i].getSurfaceArea() > largestBox.getSurfaceArea()) {
                largestBox = boxes[i];
            }
        }

        return largestBox;
    }

    // Method to report various information
    public static void reportInformation(double averageSurfaceArea, Box[] boxes, Box largestBox) {
        System.out.printf("a. The average surface area of all the Box objects: %.2f%n", averageSurfaceArea);

        System.out.print("b. The indices of all the Box objects whose surface area is larger than the average surface area: ");
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].getSurfaceArea() > averageSurfaceArea) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("c. The index, surface area, and dimensions of the box with the largest surface area:");
        int indexOfLargestBox = -1;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == largestBox) {
                indexOfLargestBox = i;
                break;
            }
        }
        System.out.println("   Index: " + indexOfLargestBox);
        System.out.printf("   Surface Area: %.2f%n", largestBox.getSurfaceArea());
        System.out.printf("   Dimensions: Length = %.2f, Width = %.2f, Height = %.2f%n", largestBox.getLength(), largestBox.getWidth(), largestBox.getHeight());

        // Count boxes larger and smaller than the average surface area
        int countLargerThanAverage = 0;
        int countSmallerThanAverage = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].getSurfaceArea() > averageSurfaceArea) {
                countLargerThanAverage++;
            } else if (boxes[i].getSurfaceArea() < averageSurfaceArea) {
                countSmallerThanAverage++;
            }
        }
        System.out.println("d. The number of boxes whose surface area is larger than the average surface area: " + countLargerThanAverage);
        System.out.println("e. The number of boxes whose surface area is smaller than the average surface area: " + countSmallerThanAverage);
    }
}