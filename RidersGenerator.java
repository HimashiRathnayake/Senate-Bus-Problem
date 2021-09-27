import java.util.Random;

public class RidersGenerator extends Thread {

    private float arrivalMeanTime;
    private static Random random;

    public RidersGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }

    @Override
    public void run() {

        int riderIndex = 1;
        while (!Thread.currentThread().isInterrupted()) {

            try {
                long next_time = getInterArrivalTime();
                System.out.println("Rider arrived. Next Rider will arrive after " + String.valueOf(next_time) + " milliseconds");
                Rider rider = new Rider(SemaphoreStore.mutex, SemaphoreStore.bus, SemaphoreStore.allAboard, SemaphoreStore.multiplex, "Rider_"+String.valueOf(riderIndex));
                rider.start();

                riderIndex++;
                Thread.sleep(getInterArrivalTime());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getInterArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}