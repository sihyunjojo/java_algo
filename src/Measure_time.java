import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

public class Measure_time{
    public static void runFunction(Func func) throws IOException {
        long startTime = System.nanoTime();
        func.apply();
        long endTime = System.nanoTime();
        long elapsedTime  = endTime - startTime;

        System.out.println();
        System.out.printf("시간차이(ms) : %f", elapsedTime * 1e-9);
    }
}
