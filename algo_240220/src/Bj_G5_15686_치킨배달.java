import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 모든 치킨집의 그거에 대해서 다 완탐하는 방식
//
public class Bj_G5_15686_치킨배달 {
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
            int ans = cal_min_distance(tmp_chicken);
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

    static int cal_min_distance(int[][] chickens) {
        int[][] delta = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int min_dis = 0;

        for (int i = 0; i < house.size(); i++) {
            isvisited = new boolean[n][n];

            int[] now_house = house.get(i);
            min_dis += min_chi_dis(chickens,now_house);

            if (min_dis > res) return Integer.MAX_VALUE;
        }
        return min_dis;
    }

    static int min_chi_dis(int[][] chickens, int[] house){
        int min_dis = Integer.MAX_VALUE;
        for (int[] chi : chickens) {
            int tmp = cal_dis(chi, house);
            if (min_dis > tmp) min_dis = tmp;
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




