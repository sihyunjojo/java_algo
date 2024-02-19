import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 계란으로 계란 치기
public class Main {
    public static void main(String[] args) throws IOException {
        // so easy
        int dx = 0;
        int dy = 1;
        double aaa = 90 - Math.toDegrees(Math.atan2(dy,dx));

        double a = Math.atan2(dy,dx);
        double b = Math.toDegrees(a);

        double c = Math.toRadians(b);
        double a2 = 90-b;

        // 1.5707963267948966
        System.out.println(a);
        // 90.0
        System.out.println(b);
        // 1.5707963267948966
        System.out.println(c);
        // 0.0
        System.out.println(aaa);


    }
}




