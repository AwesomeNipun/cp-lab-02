public class Rider implements Runnable {
    private Variables variables;

    public Rider(Variables variables) {
        this.variables = variables;
    }

    private void getOnboard() {
        System.out.println("Rider boarded to bus");
    }
    @Override
    public void run() {
        try {
            variables.mutex.acquire();  // protect waiting riders count
            variables.waitingRiders++;
            System.out.println("Rider " + variables.waitingRiders + " is waiting");
            variables.mutex.release();

            variables.busArrival.acquire(); // wait for bus arrival

            getOnboard();

            // this is not interrupted by threads since only one rider can access at a time after bus arrival
            variables.bus.incrementRiders();

            if (variables.bus.getRidersBoarded() == variables.waitingRiders || variables.bus.getRidersBoarded() == 50){
                variables.waitingRiders = Math.max(variables.waitingRiders-50, 0);
                variables.boarded.release();
            } else {
                variables.busArrival.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
