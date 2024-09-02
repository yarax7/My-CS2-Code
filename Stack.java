public class Stack {
    private Artwork[] arr;
    private int top;

    public Stack(int size) {
        arr = new Artwork[size];
        top = -1;
    }

    public void push(Artwork artwork) {
        if (top == arr.length - 1) {
            System.out.println("The stack is full and cannot take anymore push values");
            return;
        }
        top++;
        arr[top] = artwork;
        System.out.println("Artwork \"" + artwork.title + "\" by " + artwork.artistName + " pushed onto the stack");
    }

    public Artwork pop() {
        if (isEmpty()) {
            System.out.println("Trying to pop from an empty stack.");
            return null;
        }
        Artwork poppedArtwork = arr[top];
        arr[top] = null;
        top--;
        return poppedArtwork;
    }

    public Artwork peek() {
        if (isEmpty()) {
            System.out.println("Trying to peek an empty stack.");
            return null;
        } else {
            return arr[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println("Artist: " + arr[i].artistName + ", Title: " + arr[i].title +
                    ", Medium: " + arr[i].medium + ", Year: " + arr[i].year + ", Value: " + arr[i].value);
        }
    }

    public void sortAscendingByYear() {
        if (isEmpty()) {
        return;
        }
        int length = top + 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i].year < arr[j].year) {
                    Artwork temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void sortAscendingByName() {
        if (isEmpty()) {
        return;
        }
        int length = top + 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (organizeArtists(arr[j], arr[j + 1]) < 0) {
                    Artwork temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int organizeArtists(Artwork x, Artwork y) {
        String xArtist = x.artistName.toLowerCase();
        String yArtist = y.artistName.toLowerCase();
        return xArtist.compareTo(yArtist);
    }

    public static void main(String[] args) {
        System.out.println("Initialize a stack:");
        Stack stack = new Stack(5);
        System.out.println("Is the stack empty? " + stack.isEmpty());

        System.out.println("----------------------------");
        System.out.println("\nInput some elements on the stack:");
        stack.push(new Artwork("Da Vinci", "Mona Lisa", "Oil", 1503, 100000));
        stack.push(new Artwork("Van Gogh", "Starry Night", "Oil", 1889, 120000));
        stack.push(new Artwork("Picasso", "Guernica", "Oil", 1937, 200000));
        stack.push(new Artwork("Michelangelo", "David", "Marble", 1504, 180000));
        stack.push(new Artwork("Rembrandt", "The Night Watch", "Oil", 1642, 1500000));
        stack.display();
        System.out.println("The top object in the stack is: " + stack.peek());
        System.out.println("----------------------------");

        stack.sortAscendingByYear();
        System.out.println("Artworks sorted in ascending order by year");
        stack.display();
        System.out.println("----------------------------");

        stack.sortAscendingByName();
        System.out.println("Artworks sorted in ascending order by artist name");
        stack.display();
        System.out.println("----------------------------");

        System.out.println("Artwork \"" + stack.pop().title + "\" by " + stack.pop().artistName + " popped from the stack");
        System.out.println("Artwork \"" + stack.pop().title + "\" by " + stack.pop().artistName + " popped from the stack");
        System.out.println("----------------------------");
        stack.display();
        System.out.println("----------------------------");
    }
}