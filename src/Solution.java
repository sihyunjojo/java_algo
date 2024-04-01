import java.io.*;
import java.util.*;


public class Solution {
    static int n, r;
    static StringBuilder sb = new StringBuilder();
    static Long[] arr = new Long[1000001];
    static ArrayList<Long> arr1 = new ArrayList<>();
    static final int MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        go();

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            long under = arr[r] * arr[n - r];
            long zegop = zegop(under,MOD - 2);

            sb.append((arr[n] * zegop) % MOD).append("\n");

        }
        System.out.println(sb);
    }

    static void go() {
        arr[0] = 1L;
        for (int i = 1; i <= 1000001; i++) {
            arr[i] = arr[i-1] * i % MOD;
        }
    }

    static long zegop(long under, long up) {
        if (up == 1) {
            return under % MOD;
        }
        long l = zegop(under,up/2) % MOD;
        if (up % 2 == 1) {
            return ((l * l) % MOD * under) % MOD;
        }
        else  {
            return l * l % MOD;
        }
    }
}