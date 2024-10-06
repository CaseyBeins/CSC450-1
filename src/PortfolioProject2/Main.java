package PortfolioProject2;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        // Create the counter threads
        CounterThread countUpThread = new CounterThread(true);
        CounterThread countDownThread = new CounterThread(false);

        // Start the counting-up thread
        countUpThread.start();

        // Use join to wait for countUpThread to finish before starting countDownThread
        try {
            countUpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the counting down thread
        countDownThread.start();

        // Wait for both threads to complete
        try {
            countDownThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final message
        System.out.println("Both threads have completed execution.");
    }
}

