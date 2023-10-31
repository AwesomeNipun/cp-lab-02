import java.util.concurrent.Semaphore;

public class Variables {
    public Semaphore busArrival; // notify a rider on bus arrival
    public Semaphore mutex; // make increment of waitingRiders atomic
    public Semaphore boarded; // boarding the riders
    public Bus bus; // bus resource
    public int waitingRiders; // keep count of waiting riders

    public Variables() {
        this.busArrival = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.boarded = new Semaphore(0);
        this.waitingRiders = 0;
    }
}
