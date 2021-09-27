import java.util.concurrent.*;

class Rider extends Thread {
    Semaphore mutex;
    Semaphore bus;
    Semaphore allAboard;
    Semaphore multiplex;
    String thread_name;

    public Rider(Semaphore mutex, Semaphore bus, Semaphore allAboard, Semaphore multiplex,
            String thread_name) {
        super(thread_name);
        this.mutex = mutex;
        this.bus = bus;
        this.allAboard = allAboard;
        this.multiplex = multiplex;
        this.thread_name = thread_name;
    }

    @Override
    public void run() {
        try {
            this.multiplex.acquire();
            this.mutex.acquire();
            SenateBusProblemDemo.riders += 1;
            this.mutex.release();
            this.bus.acquire();
            this.multiplex.release();
            this.boardBus();
            SenateBusProblemDemo.riders -= 1;
            if (SenateBusProblemDemo.riders == 0) {
                this.allAboard.release();
            } else {
                this.bus.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void boardBus() {
        System.out.println("Rider " + thread_name + " board bus...............");
    }
}