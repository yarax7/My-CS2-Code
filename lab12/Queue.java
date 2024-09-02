public class Queue {
    public Customer front;
    public Customer rear;
    public int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add a customer to the queue
    public void enqueue(Customer customer) {
        if (isEmpty()) {
            front = customer;
        } else {
            rear.setNext(customer);
        }
        rear = customer;
        size++;
    }

    // Remove and return the customer at the front of the queue
    public Customer dequeue() {
        if (isEmpty()) {
            return null;
        }
        Customer removedCustomer = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return removedCustomer;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }


}