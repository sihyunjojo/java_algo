import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// bfs로 안되는 문제 같은데??
// dfs로 해야하는거 같아.

// 아니야 dfs로 하면 시간초과 나는거 같아.
// bfs로 해야하는거 같아

// 조건이 좀 꽤 있어서 dfs로 풀려했는데
// bfs로 푸는게 좋다.

// 등산로 최대 공사 가능 깊이 K가 주어진다.는 dfs가 맞고.
// 최소는 bfs이다.

// 그리고 visited 3차원해서 cnt 업데이트하는 방법 좋다.
public class Bj_G3_1600_말이되고픈원숭이 {
    static int k, w, h, res;
    static int[][] board;
    static boolean[][][] isvisited;
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] hours_move = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, -2}, {-1, -2}, {1, 2}, {-1, 2}};
    static ArrayList<int[]> no_block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][w];
        no_block = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    no_block.add(new int[]{i, j});
                }
            }
        }
        isvisited = new boolean[h][w][k + 1]; // 이 아이디어가 핵심이다.
        bfs();
        if (res == 0) res = -1;
        if (w == 1 && h == 1) res = 0; // 이것도 조심해야할듯 애매하게 항상 하나 틀릴듯
        System.out.println(res);
    }

    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, k});
        isvisited[0][0][k] = true;

        loop:
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int dis = poll[2];
            int cnt = poll[3];

            if (cnt > 0) {
                for (int d = 0; d < 8; d++) {
                    int dy = y + hours_move[d][0];
                    int dx = x + hours_move[d][1];
                    if (check_size(dy, dx)) {
                        if (!isvisited[dy][dx][cnt - 1] && board[dy][dx] == 0) {
                            if (dy == h - 1 && dx == w - 1) {
                                res = dis + 1;
                                break loop;
                            }
                            q.add(new int[]{dy, dx, dis + 1, cnt - 1});
                            isvisited[dy][dx][cnt - 1] = true;
                        }
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];

                if (check_size(dy, dx)) {
                    if (!isvisited[dy][dx][cnt] && board[dy][dx] == 0) {
                        if (dy == h - 1 && dx == w - 1) {
                            res = dis + 1;
                            break loop;
                        }
                        q.add(new int[]{dy, dx, dis + 1, cnt});
                        isvisited[dy][dx][cnt] = true;
                    }
                }
            }
        }
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}


