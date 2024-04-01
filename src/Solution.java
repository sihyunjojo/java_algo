import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Solution {
    static int n, w, h, cnt;
    static StringBuilder sb = new StringBuilder();
    static int[][] board, tmp_board;
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] isvisited;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input5656.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            tmp = new int[n];
            tmp[0] = 2;
            tmp[1] = 2;
            go();
        }
    }

    static void combi(int count) {
        if (count == n) {

            go();
        }
        for (int i = 0; i < w; i++) {
            tmp[count] = i;
            combi(count + 1);
        }
    }

    static int go() {
        cnt = 0;
        tmp_board = copyBoard();
        for (int i : tmp) {
            ArrayList<int[]> arr;
            for (int j = 0; j < h; j++) {
                if (tmp_board[j][i] != 0) {
                    broken_block(j, i, tmp_board[j][i]);
                    break;
                }
            }


        }
        return cnt;
    }

    static void broken_block(int y, int x, int num) {
        int n = num-1;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = y - n; i <= y + n; i++) {
            for (int j = x - n; j <= x + n; j++) {
                if (checkSize(i, j) && tmp_board[i][j] != 0) {
                    cnt++;
                    q.add(new int[]{i, j});
                    tmp_board[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            y = poll[0];
            x = poll[1];
            n = tmp_board[y][x]-1;
            for (int i = y - n; i <= y + n; i++) {
                for (int j = x - n; j < x + n; j++) {
                    if (checkSize(i, j)) {
                        if (board[i][j] == 0){
                            cnt++;
                        }
                        q.add(new int[]{i, j});
                        tmp_board[i][j] = 0;
                    }
                }
            }
        }
        for (int[] ints : tmp_board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
//        remove_line();
    }

    static void remove_line(int y, int x, int n) {
//        for (int i = 0; i < y; i++) {
//            // 보드 한칸 씩 내려줌.
//        }
    }

    static int[][] copyBoard() {
        int[][] tmp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        return tmp;
    }

    static boolean checkSize(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}

