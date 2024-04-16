import java.io.*;
import java.util.*;

public class Bj_용액 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long max = 1000000000;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken()) + max;
        }
        // 같은 양의 두 용액을 혼합
        long[] res = new long[2];
        long now_min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long target = -(arr[i] + max);

            int left = 0;
            int right = n;
            while (left < right) {
                int mid = (right + left) / 2;
                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            long abs = Math.abs(arr[i] + arr[right]);
            if (now_min > abs){
                res[0] = arr[i];
                res[1] = arr[right];
                now_min = abs;
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }
}