package bj;

import java.io.*;
import java.util.*;

public class Bj_S1_11660_구간합구하기4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n+1];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = 0;
            for (int j = 1; j <= n; j++){
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(arr[i]));
        }

        for (int i =0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int j = y1-1; j <= y2-1; j++){
                result += arr[j][x2] - arr[j][x1-1];
            }
            if (y1==y2) {
                result = arr[y1-1][x2] - arr[y1-1][x1-1];
//                System.out.println(arr[y1-1][x2]);
//                System.out.println(arr[y1-1][x1-1]);
            }
//            System.out.println();
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
