package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Swea_2805 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int result = 0;
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];
            int center = n / 2;
            int a = -1;
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                if (i <= n / 2) {
                    a += 1;
                } else {
                    a -= 1;
                }
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                    if (j == center) result += arr[i][j];
                }
                for (int j = 1; j <= a; j++) {
                    result += arr[i][center + j];
                    result += arr[i][center - j];
                }
            }


            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
