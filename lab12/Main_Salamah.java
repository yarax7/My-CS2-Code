public class Main_Salamah {

    /**
     * Remove customers with a specific ID from the queue.
     * @param queue The queue from which customers will be removed.
     * @param customerID The ID of the customer to be removed.
     * @return A new queue without the customers with the specified ID.
     */
    public static Queue dequeueCustomerByID(Queue queue, int customerID) {
        Queue temp = new Queue(); //New queue that will get updated and returned.

        if(queue == null || queue.isEmpty()){ //Checks cases of empty queues.
            return temp;
        }

        while(!queue.isEmpty()){ 
            Customer customer = queue.dequeue(); //Current customer. 

            if(customer.customerID != customerID){ //Keeps the customer in the queue if they are not specified to be removed by ID. 
                temp.enqueue(customer);
            }
        }

        return temp;//Returns the new queue.
    }

    /**
     * Remove all preferred customers from the queue.
     * @param queue The queue from which preferred customers will be removed.
     * @return A new queue containing only preferred customers.
     */
    public static Queue dequeuePreferredCustomers(Queue queue) {

        if(queue == null || queue.isEmpty()){ //Checks cases of empty queues.
            return queue;
        }

        while(!queue.isEmpty()){
            Customer customer = queue.dequeue(); //Current customer. 
            if(!customer.isPreferred){
                System.out.println(customer); //Prints the customers that are not preferred.
            } 
        }

        return queue; //Returns the queue with no preferred customers. 
    }


    /**
     * Calculate the average time customers spend in the queue.
     * @param queue The queue of customers.
     * @return The original queue
     * prints the average.
     */
    public static Queue averageTimeInQueue(Queue queue) {
        Queue temp = new Queue(); //A queue created in order to not lose our original queue. 

        if(queue == null || queue.isEmpty()){ //Checks cases of empty queues.
            return temp;
        }

        //Initializing average variables outside loop
        int total=0; 
        int count=0;

        while(!queue.isEmpty()){
            Customer customer = queue.dequeue(); //Current customer in queue. 
            total += customer.minutesInsideQueue;
            count++;
            temp.enqueue(customer);
        }

        //Computes avg and prints it
        double avg = total/count; 
        System.out.println(avg); 

        return temp; //Returns the original queue. 
    }

    /**
     * Get the customer with the longest wait time.
     * @param queue The queue of customers.
     * @return the queue of customers
     * prints The customer with the longest wait time.
     */
    public static Queue getLongestWaitTime(Queue queue) {
        Queue temp = new Queue(); //New queue that is created so our original does not get lost. 

        if(queue == null || queue.isEmpty()){ //Checks cases of empty queues.
            return temp;
        }

        Customer longestWait = new Customer(); //Customer variable placeholder that will be printed later.
        int max = 0; //Initializing max variable. 
        while(!queue.isEmpty()){
            Customer customer = queue.dequeue(); //Current customer. 
            if(customer.minutesInsideQueue>max){ //Updates max variable as needed. 
                max = customer.minutesInsideQueue;
                longestWait = customer; 
            }
            temp.enqueue(customer); //Adds original values to new queue. 
        }

        System.out.println(longestWait); 

        return temp; //Prints original queue. 
    }

    /**
     * Print the whole queue.
     * @param queue The queue to be printed.
     * @return The same queue after printing.
     */
    public static Queue printQueue(Queue queue) {
        Queue temp = new Queue(); //Creates a new queue so our original one doesnt get lost. 

        if(queue == null || queue.isEmpty()){ //Checks cases of empty queues.
            return temp;
        }

        while(!queue.isEmpty()){
            Customer tempCustomer = queue.dequeue(); //Current customer. 
            System.out.println(tempCustomer); //Prints. 
            temp.enqueue(tempCustomer); //Updates new queue. 
        }

        return temp; //Returns new queue. 
    }

    public static void main(String[] args) {

        // Create a queue
        Queue customerQueue = new Queue();

        // Create customers
        Customer customer1 = new Customer("Macmillan", 588190, 15, true);
        Customer customer2 = new Customer("Abbott", 588182, 15, false);
        Customer customer3 = new Customer("Bones", 588173, 34, true);
        Customer customer4 = new Customer("Smith", 588139, 23, false);
        Customer customer5 = new Customer("Finch", 588112, 55, true);

        // Add customers to the queue
        customerQueue.enqueue(customer1);
        customerQueue.enqueue(customer2);
        customerQueue.enqueue(customer3);
        customerQueue.enqueue(customer4);
        customerQueue.enqueue(customer5);

        System.out.println("------------------------------------------------");
        System.out.println("Printing Queue:");
        customerQueue = printQueue(customerQueue);

        System.out.println("------------------------------------------------");

        // Dequeue a customer by their ID
        System.out.println("Dequeue customer with ID: 588173");
        customerQueue = dequeueCustomerByID(customerQueue, 588173);
        customerQueue = printQueue(customerQueue);

        System.out.println("------------------------------------------------");

        // Calculate the average time customers spend in the queue
        System.out.println("Average time in queue: " );
        customerQueue = averageTimeInQueue(customerQueue);

        System.out.println("------------------------------------------------");

        // Get the customer with the longest wait time
        System.out.println("Customer with longest wait time: ");
        customerQueue = getLongestWaitTime(customerQueue);

        System.out.println("------------------------------------------------");

        // Remove preferred customers
        System.out.println("Removing preferred customers: " );
        customerQueue = printQueue(dequeuePreferredCustomers(customerQueue));


    }
}