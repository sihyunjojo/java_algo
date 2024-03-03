import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 입구 도착 후 1분 뒤에 내려갈 수 있음
// 계단 위에 동시 최대 3명까지만 가능
// 이미 계단 3명 내려가고 있는 경우, 1명이 완전히 내려갈 때까지 계단입구에서 대기
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n, res;
    static int[][] board;
    static boolean[][] isvisited;
    static int[] ;
    static int[][] delta = new int[][]{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input2105.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            System.out.println("===================="+t);
            sb.append("#").append(t).append(" ");

            n = Integer.parseInt(br.readLine());
            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            res = -1;
            isvisited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    isvisited[i][j] = true;
                    dfs(i,j,i,j);
                    isvisited[i][j] = false;
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x,int init_y, int init_x,int del) {
        if (y == init_y && x == init_x && del == 3){
        }
        for (int d = 0; d <4; d++){
            int dy = y + delta[d][0];
            int dx = x + delta[d][1];
            if (check_size(y,x) && !isvisited[dy][dx]){
                isvisited[dy][dx] = true;
                dfs(dy,dx,init_y,init_x,d);
                isvisited[dy][dx] = false;
            }

        }
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
