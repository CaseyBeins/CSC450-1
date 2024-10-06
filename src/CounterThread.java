@SuppressWarnings("ALL")
class CounterThread extends Thread {
    private boolean countUp; // Flag to determine if the thread counts up or down

    public CounterThread(boolean countUp) {
        this.countUp = countUp;
    }

    @Override
    public void run() {
        if (countUp) {
            // Count up from 1 to 20
            for (int i = 1; i <= 20; i++) {
                System.out.println("Counting up: " + i);
                try {
                    Thread.sleep(200); // Sleep for 200 milliseconds to simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Count down from 20 to 0
            for (int i = 20; i >= 0; i--) {
                System.out.println("Counting down: " + i);
                try {
                    Thread.sleep(200); // Sleep for 200 milliseconds to simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
