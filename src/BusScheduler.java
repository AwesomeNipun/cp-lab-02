public class BusScheduler implements Runnable{
    private Variables variables;
    private TimeGenerator timeGenerator;
    private final int meanTime = 2*60*1000;

    public BusScheduler(Variables variables) {
        this.variables = variables;
        this.timeGenerator = new TimeGenerator();
    }

    @Override
    public void run() {
        while (true) {
            try {
                long sleepTime = timeGenerator.generate(meanTime);
                System.out.println("\nNext bus arrival time :"+sleepTime/1000 + " seconds");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Bus(variables)).start(); // new Thread(new Bus(variables)).start();
        }
    }
}
