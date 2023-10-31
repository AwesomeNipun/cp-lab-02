import java.util.Random;

public class TimeGenerator {

    public static Random random;

    public TimeGenerator() {
        random = new Random();
    }

    public long generate(int meanTime){
        float lambda = (float) 1/meanTime;
        long time = Math.round(-Math.log(1 - random.nextFloat()) / lambda);
        return time;
    }

}
