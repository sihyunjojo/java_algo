package special;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어디서든지 true를 해주면 false를 해줘야한다.
public class Bj_G4_테크노미노 {
    static int[][] board;
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    static int n, m, res;
    static boolean[][] isvisited;
    public static void main(String[] args) throws IOException {
        // 정사각형 4개를 변으로 이어 붙인 게 테트로미노이다.
        // 대칭 회전 가능.
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isvisited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                int cnt = board[i][j];
                isvisited[i][j] = true;
                bfs(i, j, cnt,0);
                isvisited[i][j] = false;
                yoooo(i,j, cnt);

            }
        }
        System.out.println(res);
    }
    static boolean check_size(int y, int x){
        return 0 <= x && 0 <= y && x < m && y < n;
    }

    static void bfs(int i, int j, int cnt, int count){
        if (count == 3){
            if (res < cnt) res = cnt;
            return;
        }
        for (int d = 0; d < 4; d++) {
            int dy = i + delta[d][0];
            int dx = j + delta[d][1];
            if (check_size(dy, dx)){
                if (!isvisited[dy][dx]){
                    isvisited[dy][dx] = true;
                    bfs(dy, dx,cnt + board[dy][dx],count+1);
                    isvisited[dy][dx] = false;
                }
            }
        }
    }

    static void yoooo(int y, int x, int cnt){
        loop:
        for (int d = 0; d < 4; d++){
            int tmp = cnt;

            for (int i = 0; i < 4; i++){
                if (d == i) continue;
                int dy = y + delta[i][0];
                int dx = x + delta[i][1];
                if (!check_size(dy,dx)) continue loop;
                tmp += board[dy][dx];
            }
            if (res < tmp) res = tmp;
        }

//        for (int d= 0; d < 4; d++) {
//            int dy = y + delta[d][0];
//            int dx = x + delta[d][1];
//            if (!check_size(dy, dx)) continue;
//            cnt += board[dy][dx];
//        }
//
//        for (int d= 0; d < 4; d++) {
//            int dy = y + delta[d][0];
//            int dx = x + delta[d][1];
//            if (!check_size(dy, dx)) continue;
//            if (res < cnt - board[dy][dx]) res = cnt - board[dy][dx];
//        }

    }
}

