package swea.hw;

import java.io.*;
import java.util.StringTokenizer;

public class Swea_1954 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./input3.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][n];
            int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
            int d = 0; // 델타의 인자를 맡음.
            int x = -1;
            int y = 0;

            int num = 0;
            while (num < Math.pow(n,2)){
                y += delta[d][0];
                x += delta[d][1];
                if (check(y, x, n)){
                    if (board[y][x] == 0){
                        num++;
                        board[y][x] = num;
                        continue;
                    }
                }
                y -= delta[d][0];
                x -= delta[d][1];
                d = (d + 1) % 4;
            }

            System.out.println("#"+ tc);
            for (int i = 0; i < n; i++){
                for (int j =0; j<n; j++){
                    bw.write(board[i][j] + " ");
                }
                bw.newLine();
            }

            bw.flush();
        }
    }
    private static boolean check(int y, int x, int n){
        return y >= 0 && y < n && x >= 0 && x < n;

    }
}
