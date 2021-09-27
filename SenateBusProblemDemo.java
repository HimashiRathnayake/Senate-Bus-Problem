public class SenateBusProblemDemo {
    public static int riders;
    public static void main(String args[]) throws InterruptedException {
        riders = 0;

        float bus_inter_arrival_time = 20 * 60 * 1000;
        float riders_inter_arrival_time = 30 * 1000;

        RidersGenerator riderGenerator = new RidersGenerator(riders_inter_arrival_time);
        riderGenerator.start();

        BusGenerator busGenerator = new BusGenerator(bus_inter_arrival_time);
        busGenerator.start();
    }
}