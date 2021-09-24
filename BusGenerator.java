import java.util.Random;

public class BusGenerator extends Thread {

    private float arrivalMeanTime;
    private static Random random;

    public BusGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }

    @Override
    public void run() {

        int busIndex = 1;

        while (!Thread.currentThread().isInterrupted()) {

            try {
                Bus bus = new Bus(SemaphoreStore.mutex, SemaphoreStore.bus, SemaphoreStore.allAboard, "Bus_"+String.valueOf(busIndex));
                bus.start();

                busIndex++;
                Thread.sleep(getInterArrivalTime());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All buses have finished arriving");
    }

    public long getInterArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}