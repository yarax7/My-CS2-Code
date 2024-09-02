import java.util.Scanner;

public class Stack{
    private Artwork[] arr;
    private int top;

    // Constructor to initialize the stack with given size
    public Stack(int size) {
        arr = new Artwork[size];
        top = -1;
    }

    /**
     * Pushes an Artwork object onto the stack.
     * 
     * @param artwork The Artwork object to be pushed onto the stack.
     */
    public void push(Artwork artwork) {
        if(top==arr.length-1){ // Check if the stack is full
            System.out.println("The stack is full and cannot take anymore push values");
            return;
        } 
        top++; // Increment top to point to the next empty position
        arr[top] = artwork; // Add the artwork to the stack
        System.out.println("Artwork \"" + artwork.title + "\" by " + artwork.artistName + " pushed onto the stack");
    }

    /**
     * Pops an Artwork object from the stack.
     * 
     * @return The Artwork object popped from the stack, or null if the stack is empty.
     */
    public Artwork pop() {
        if(isEmpty()){
            System.out.println("Trying to peek an empty stack.");
            return null;
        }
        Artwork poppedArt = arr[top]; // Get the top artwork from the stack
        arr[top]=null;
        System.out.println("Artwork \"" + poppedArt.title + "\" by " + poppedArt.artistName + " popped from the stack");
        top--; // Decrement top to remove the top element
        return poppedArt;
    }

    /**
     * Retrieves the top Artwork object from the stack without removing it.
     * 
     * @return The top Artwork object from the stack, or null if the stack is empty.
     */
    public Artwork peek() {
        if(isEmpty()){ // Check if the stack is empty
            System.out.println("Trying to peek an empty stack.");
            return null;
        } else {
            return arr[top]; // Return the top artwork from the stack
        }
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Sorts the artworks in ascending order by year.
     */
    public void sortAscendingByYear() {
        System.out.println("Artworks sorted in ascending order by year:");
        if (isEmpty()) { // Check if the stack is empty
        return;
        }
        int length = top + 1; // Calculate the number of elements in the stack
        // Bubble sort:
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i].year < arr[j].year) {
                    // Swap artworks if they are out of order
                    Artwork temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the artworks in ascending order by artist name.
     */
    public void sortAscendingByName() {
        System.out.println("Artworks sorted in ascending order by artist name: ");
        if (isEmpty()) { // Check if the stack is empty
        return;
        }
        int length = top + 1; // Calculate the number of elements in the stack
        // Bubble sort:
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (organizeArtists(arr[j], arr[j + 1]) < 0) { // Compare artist names
                    Artwork temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int organizeArtists(Artwork x, Artwork y){
        String xArtist = x.artistName.toLowerCase();
        String yArtist = y.artistName.toLowerCase();
        return xArtist.compareTo(yArtist); // Compare artist names
    }
    /**
     * Displays the elements of the stack.
     */
    public void display() {
        if (isEmpty()) { // Check if the stack is empty
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements:");
        // Iterate over the stack from top to bottom and print each artwork
        for (int i = top; i >= 0; i--) {
            System.out.println("Artist: " + arr[i].artistName + ", Title: " + arr[i].title + ", Medium: " + arr[i].medium + ", Year: " + arr[i].year + ", Value: " + arr[i].value);
        }
    }

    public static void main(String[] args) {
        System.out.println("Initialize a stack:");
        Stack stack = new Stack(5);
        System.out.println("Is the stack empty? " + stack.isEmpty());

        System.out.println("-----------------------------");
        System.out.println("\nInput some elements on the stack:");
        stack.push(new Artwork("Da Vinci", "Mona Lisa", "Oil", 1503, 100000));
        stack.push(new Artwork("Van Gogh", "Starry Night", "Oil", 1889, 120000));
        stack.push(new Artwork("Picasso", "Guernica", "Oil", 1937, 200000));
        stack.push(new Artwork("Michelangelo", "David", "Marble", 1504, 180000));
        stack.push(new Artwork("Rembrandt", "The Night Watch", "Oil", 1642, 1500000));
        stack.display();
        System.out.println("The top object in the stack is: " + stack.peek());
        System.out.println("-----------------------------");

        stack.sortAscendingByYear();
        stack.display();
        System.out.println("-----------------------------");
        
        stack.sortAscendingByName();
        stack.display();
        System.out.println("-----------------------------");

        stack.pop();
        stack.pop();
        System.out.println("-----------------------------");
        stack.display();
        System.out.println("-----------------------------");
    }
}