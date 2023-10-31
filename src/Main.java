public class Main {
    public static void main(String[] args) {

        Variables variables = new Variables();
        Thread busScheduler = new Thread(new BusScheduler(variables));
        Thread riderScheduler = new Thread(new RiderScheduler(variables));

        busScheduler.start();
        riderScheduler.start();

        try {
            busScheduler.join();
            riderScheduler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program terminated");
    }
}
