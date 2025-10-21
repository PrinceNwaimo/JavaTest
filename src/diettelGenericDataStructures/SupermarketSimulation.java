package diettelGenericDataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SupermarketSimulation {
    private static final int SIMULATION_TIME = 720; // 12 hours in minutes
    private Queue<Customer> queue;
    private Random random;
    private int currentTime;
    private int maxQueueSize;
    private int longestWait;
    private int customerCount;

    public SupermarketSimulation() {
        this.queue = new java.util.LinkedList<>();
        this.random = new Random();
        this.currentTime = 0;
        this.maxQueueSize = 0;
        this.longestWait = 0;
        this.customerCount = 0;
    }

    public void simulate() {
        int nextArrivalTime = random.nextInt(4) + 1; // 1 to 4 minutes
        int serviceTime = 0;
        Customer currentCustomer = null;

        while (currentTime < SIMULATION_TIME) {
            // Customer arrival
            if (currentTime == nextArrivalTime) {
                int customerServiceTime = random.nextInt(4) + 1; // 1 to 4 minutes
                Customer customer = new Customer(currentTime, customerServiceTime);
                queue.add(customer);
                customerCount++;
                maxQueueSize = Math.max(maxQueueSize, queue.size());
                nextArrivalTime = currentTime + random.nextInt(4) + 1;
            }

            // Serving customer
            if (currentCustomer == null && !queue.isEmpty()) {
                currentCustomer = queue.poll();
                serviceTime = currentCustomer.serviceTime;
                int waitTime = currentTime - currentCustomer.arrivalTime;
                longestWait = Math.max(longestWait, waitTime);
            }

            if (currentCustomer != null) {
                serviceTime--;
                if (serviceTime == 0) {
                    currentCustomer = null;
                }
            }

            currentTime++;
        }

        System.out.println("Simulation Results:");
        System.out.println("a) Maximum number of customers in the queue: " + maxQueueSize);
        System.out.println("b) Longest wait experienced by a customer: " + longestWait + " minutes");
    }

    public void simulateWithArrivalIntervalChange() {
        // Changing arrival interval to 1 to 3 minutes
        int SIMULATION_TIME = 720;
        Queue<Customer> queue = new LinkedList<>();
        Random random = new Random();
        int currentTime = 0;
        int maxQueueSize = 0;
        int longestWait = 0;
        int customerCount = 0;
        int nextArrivalTime = random.nextInt(3) + 1; // 1 to 3 minutes
        int serviceTime = 0;
        Customer currentCustomer = null;

        while (currentTime < SIMULATION_TIME) {
            // Customer arrival
            if (currentTime == nextArrivalTime) {
                int customerServiceTime = random.nextInt(4) + 1; // 1 to 4 minutes
                Customer customer = new Customer(currentTime, customerServiceTime);
                queue.add(customer);
                customerCount++;
                maxQueueSize = Math.max(maxQueueSize, queue.size());
                nextArrivalTime = currentTime + random.nextInt(3) + 1;
            }

            // Serving customer
            if (currentCustomer == null && !queue.isEmpty()) {
                currentCustomer = queue.poll();
                serviceTime = currentCustomer.serviceTime;
                int waitTime = currentTime - currentCustomer.arrivalTime;
                longestWait = Math.max(longestWait, waitTime);
            }

            if (currentCustomer != null) {
                serviceTime--;
                if (serviceTime == 0) {
                    currentCustomer = null;
                }
            }

            currentTime++;
        }

        System.out.println("\nSimulation Results with arrival interval 1-3 minutes:");
        System.out.println("c) Maximum number of customers in the queue: " + maxQueueSize);
        System.out.println("   Longest wait experienced by a customer: " + longestWait + " minutes");
    }

    public static void main(String[] args) {
        SupermarketSimulation simulation = new SupermarketSimulation();
        simulation.simulate();
        simulation.simulateWithArrivalIntervalChange();
    }
}
