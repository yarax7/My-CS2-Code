public class Customer {
    public String lastName;
    public int customerID;
    public int minutesInsideQueue;
    public boolean isPreferred;
    public Customer next; // Reference to the next customer in the queue

    public Customer() {
    }

    public Customer(String lastName, int customerID, int minutesInsideQueue, boolean isPreferred) {
        this.lastName = lastName;
        this.customerID = customerID;
        this.minutesInsideQueue = minutesInsideQueue;
        this.isPreferred = isPreferred;
        this.next = null; // Initialize the next reference to null
    }

    // Getter and setter methods for attributes

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }

    // toString() method to print customer details

    @Override
    public String toString() {
        return "Customer" +
                "lastName='" + lastName + '\'' +
                ", customerID=" + customerID +
                ", minutesInsideQueue=" + minutesInsideQueue +
                ", isPreferred=" + isPreferred +
                ' ';
    }
}