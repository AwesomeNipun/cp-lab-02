public class Bus implements Runnable{
    private Variables variables;
    private int ridersBoarded;

    public Bus(Variables variables) {
        this.variables = variables;
    }

    public int getRidersBoarded() {
        return ridersBoarded;
    }

    public void incrementRiders(){
        this.ridersBoarded++;
    }

    private void depart(){
        System.out.println("Bus loaded with :" + ridersBoarded + " riders" );
        System.out.println("Riders waiting :" + variables.waitingRiders);
        System.out.println("==============Bus has departed=============\n");
    }

    @Override
    public void run() {
        try {
            variables.mutex.acquire();  // avoid new riders when the bus has arrived
            int waitingRiders = variables.waitingRiders;
            System.out.println("\n================Bus has arrived=============");
            System.out.println("Riders waiting for bus : "+ waitingRiders);
            System.out.println("Maximum number of riders who can board : "+ Math.min(waitingRiders,50));
            if (waitingRiders > 0){
                variables.bus = this;
                variables.busArrival.release(); // signal a rider that the bus has arrived
                variables.boarded.acquire();    // wait until all the waiting riders have boarded
            }
            depart();   // depart from the bus stop
            variables.mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
