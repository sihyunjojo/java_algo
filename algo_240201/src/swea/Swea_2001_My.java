package swea;

import java.io.*;
import java.util.StringTokenizer;

// 무식한 4중 포문
// 원래 나는 더 무식하게 하나의 위치당 4개 9개 이렇게 만든 다음에 옮겨주려고 했음.
// 그거 보단 덜 무식한듯.
public class Swea_2001_My {
    public static void main(String args[]) throws Exception {
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
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i <= n-m; i++){
                for (int j = 0; j <= n-m; j++){
                    int tmp = 0;
                    for (int k = i; k < i+m; k++){
                        for (int l = j; l < j+m; l++){
                            tmp += board[k][l];
                        }
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
