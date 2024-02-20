import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 모든 치킨집의 그거에 대해서 다 완탐하는 방식
//
public class Main {
    static int n, m, res;
    static int[][] board;
    static boolean isused[], isvisited[][];
    static ArrayList<int[]> house, chicken;
    static int[][] tmp_chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        res = Integer.MAX_VALUE;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
                if (board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        isused = new boolean[chicken.size()];
        tmp_chicken = new int[m][2];
        go(0, 0);
        System.out.println(res);

    }

    static void go(int count, int start) {
        if (count == m) {
            System.out.println(Arrays.deepToString(tmp_chicken));
            int ans = cal_min_distance(tmp_chicken);
            System.out.println(ans);
            if (res > ans) res = ans;
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (isused[i]) continue;
            tmp_chicken[count] = chicken.get(i);
            isused[i] = true;
            go(count + 1, i + 1);
            isused[i] = false;
        }
    }

    static int cal_min_distance(int[][] chicken) {
        int[][] delta = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int min_dis = 0;

        isvisited = new boolean[n][n];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < house.size(); i++) {
            int[] now_house =  house.get(i);
            q.addFirst(new int[]{now_house[0],now_house[1]});
            isvisited[now_house[0]][now_house[1]] = true;

            loop:
            while (!q.isEmpty()) {
                int[] poll = q.pollFirst();
                int y = poll[0];
                int x = poll[1];

                for (int d = 0; d < 4; d++) {
                    int dy = y + delta[d][0];
                    int dx = x + delta[d][1];
                    if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == 2) {
                        min_dis += cal_dis(new int[]{dy, dx}, now_house);
                        System.out.println("chi" + Arrays.toString(now_house) + "board" + dy+" "+dx);
                        break loop;
                        //                    System.out.println("bfs" + min_dis+" "+ dy+ " "+dx);
                    }
                    if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == 0) {
                        q.addFirst(new int[]{dy, dx});
                        isvisited[dy][dx] = true;
                    }
                }
            }
        }
        return min_dis;
    }

    static int cal_dis(int[] house, int[] chi){
        return Math.abs(house[0] - chi[0]) + Math.abs(house[1] - chi[1]);
    }
    static boolean check_size(int y, int x) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }
}




