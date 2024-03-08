import java.io.*;
import java.util.StringTokenizer;

// 중복합 알고리즘
public class Swea_D2_2001_파리퇴치_Best {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputFile/input4.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = 0;
            int[][] board = new int[n][n+1];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n+1; j++){
                    board[i][j] = Integer.parseInt(st.nextToken()) + board[i][j-1];
                }
            }

            for (int i = 0; i <= n-m; i++){
                for (int j = 1; j <= n-m+1; j++){
                    int tmp = 0;
                    for (int k = i; k < i+m; k++){
                        tmp += board[k][j+m-1] - board[k][j-1];
                    }
                    if (result < tmp) {
                        result = tmp;
                    }
                }
            }


            bw.write("#"+ tc + " " + result+ "\n");


        }
        bw.flush();
    }
}
