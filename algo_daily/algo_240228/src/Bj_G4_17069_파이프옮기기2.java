import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 자료형 주의주의
public class Bj_G4_17069_파이프옮기기2 {
    static int n, m, res;
    static int[] arr;
    static ArrayList<Integer>[] relation;
    static boolean[] isvisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[3][n][n];

        // 가로로 정렬 된거 y가 0일떄는 전부 1
//        Arrays.fill(dp[0][0],1);
        for (int i = 1; i < n; i++){
            if (board[0][i] == 1) break;
            dp[0][0][i] = 1;
        }
        // 세로로 정렬 된거 x가 1일떄는 전부 1

        for (int i = 1; i < n; i++){ // y
            for (int j = 2; j < n; j++) {
                if (board[i][j] == 1) continue;
                if (board[i][j-1] == 0){
                    dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
                }
                if (board[i-1][j] == 0){
                    dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
                }
                if (board[i-1][j] == 0 && board[i][j-1] == 0 && board[i-1][j-1] == 0){
                    dp[2][i][j] = dp[0][i-1][j-1] +dp[1][i-1][j-1] +dp[2][i-1][j-1];
                }
            }
        }

        for (long[] ints : dp[0]) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();        for (long[] ints : dp[1]) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();        for (long[] ints : dp[2]) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]);

    }
}


