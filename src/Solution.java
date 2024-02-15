import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[][] board = new int[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] home = new int[2];
            int[] company = new int[2];
            int[][] guest_arr = new int[n][2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
               guest_arr[i][0] = Integer.parseInt(st.nextToken());
               guest_arr[i][1] = Integer.parseInt(st.nextToken());
            }

            board = new int[n+2][n+2];
            for (int i = 0; i < n+2; i++){
                for (int j = 0; j < n+2; j++){

                }
            }

        }
        System.out.println(sb);
    }

    private static int cal_dis(int[] place1, int[] place2) {
        return Math.abs(place1[0]-place2[0]) + Math.abs(place1[1] - place2[1]);
    }
}