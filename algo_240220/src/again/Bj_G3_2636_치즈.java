package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 테두리를 구하는 로직을 생각하는 문제.
// 생각을 할때, 1에서부터 생각하는게 아닌 0에서부터 생각을 하는 아이디어가 굉장히 중요한 문제
public class Bj_G3_2636_치즈 {
    static int[][] board;
    static boolean[][] isvisited;
    static int hei, wid, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = 0;
        hei = Integer.parseInt(st.nextToken());
        wid = Integer.parseInt(st.nextToken());

        board = new int[hei][wid];
        for (int i = 0; i < hei; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < wid; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) res += 1;
            }
        }
        time = 0;
        while (true) {
            isvisited = new boolean[hei][wid];
            int remove_cheese = disappearing_cheese();
            print_board(board);
            if (remove_cheese == 0) break;
            time++;
            res = remove_cheese;
        }

        System.out.println(time);
        System.out.println(res);
    }

    static int disappearing_cheese() {
        int cnt = 0;
        int[][] delta = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        isvisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            for (int d = 0; d < 4; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];
                if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == 0) {
                    q.add(new int[]{dy, dx});
                    isvisited[dy][dx] = true;
                }
                if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == 1) {
                    board[dy][dx] = 2;
                    isvisited[dy][dx] = true;
                }
            }
        }

        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < wid; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                    cnt += 1;
                }
            }
        }
        return cnt;
    }


    static boolean check_size(int y, int x) {
        return 0 <= y && y < hei && 0 <= x && x < wid;
    }

    static void print_board(int[][] board) {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}




