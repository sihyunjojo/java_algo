import java.io.*;
import java.util.*;


public class Swea_1247_최적경로 {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int n,result;
    static boolean[] isvisited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[][] arr = new int[n+2][2];

            for (int i = 0; i < n+2; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            board = new int[n+2][n+2];
            for (int i = 0; i < n+2; i++){
                for (int j = 0; j < n+2; j++){
                    board[i][j] = cal_dis(arr[i],arr[j]);
                }
            }

            isvisited = new boolean[n+2];
            result = Integer.MAX_VALUE;

            p(0,0,0);

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    // 순열
    private static void p(int count, int last, int dis){
        if (count == n){
            dis += board[1][last];
            if (result > dis) result = dis;
            return;
        }

        for (int i = 2; i < n+2; i++){
            if (isvisited[i]) continue;
            isvisited[i] = true;
            dis += board[last][i];
            p(count+1,i,dis);
            dis -= board[last][i];
            isvisited[i] = false;
        }
    }

    private static int cal_dis(int[] place1, int[] place2) {
        return Math.abs(place1[0]-place2[0]) + Math.abs(place1[1] - place2[1]);
    }
}