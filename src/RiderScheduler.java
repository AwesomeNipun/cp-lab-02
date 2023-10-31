public class RiderScheduler implements Runnable{
    private Variables variables;
    private TimeGenerator timeGenerator;
    private final int meanTime = 3*1000;

    public RiderScheduler(Variables variables) {
        this.variables = variables;
        this.timeGenerator = new TimeGenerator();
    }

    @Override
    public void run() {
        while (true) {
            try {
                long sleepTime = timeGenerator.generate(meanTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread().start(); // new Thread(new Rider(variables)).start();
        }
    }
}
