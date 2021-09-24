import java.util.concurrent.*;

class Bus extends Thread {
    Semaphore mutex;
    Semaphore bus;
    Semaphore allAboard;
    String thread_name;

    public Bus(Semaphore mutex, Semaphore bus, Semaphore allAboard, String thread_name) {
        super(thread_name);
        this.mutex = mutex;
        this.bus = bus;
        this.allAboard = allAboard;
        this.thread_name = thread_name;
    }

    @Override
    public void run() {
        try {
            this.mutex.acquire();
            // System.out.println("bus rider - "+ SemaphoreDemo.riders);
            if (SemaphoreDemo.riders > 0) {
                this.bus.release();
                this.allAboard.acquire();
            }
            this.mutex.release();
            depart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void depart() {
        System.out.println("Bus Depart " + thread_name + "...............");
    }

}