package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Bj_G3_20058_마법사상어와파이어스톰 {
    static int[][] board;
    static int n, two_pow_n;

    public static void main(String[] args) throws IOException {
        // 2n제곱의 보드
        // 보드의 값은 얼음의 양
        // 파이어스톰을 시전하려면 l을 결정해야한다.
        // - > 부분격자로 나눈후 90도로 회전을 한다.
        // 이후 얼음이 있는 칸을 줄여줌.
        // 파이어스톰을 q만큼 시전
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        two_pow_n = (int) Math.pow(2, n);

        board = new int[two_pow_n][two_pow_n];

        for (int i = 0; i < two_pow_n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < two_pow_n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        int[] magics = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int magic_num = Integer.parseInt(st.nextToken());
            go(magic_num);
        }

        System.out.println(ice_sum());
        System.out.println(biggest_ice_class());
    }

    static void go(int num) {
        turn(num);
        print_board(board);
        full_search_minus();
        print_board(board);
    }

    static void turn(int num) {
        // 이거 복사 재대로 안됬을 수 도 있다.
        int[][] temp_board = new int[two_pow_n][two_pow_n];
        System.out.println(num);
        int two_pow = (int) Math.pow(2, num);

        for (int i = 0; i < two_pow_n; i = i + two_pow) {
            for (int j = 0; j < two_pow_n; j = j + two_pow) {

                for (int k = i; k < i + two_pow; k++) {
                    for (int l = j; l < j + two_pow; l++) {
                        temp_board[i + (l-j) ][j + (two_pow- (k-i) -1)] = board[k][l]; // 이걸 반드시 외워야해
                        //  [j][size-j-1]= [i][j]
                    }
                }
            }
        }
        board = temp_board;
    }

    static void full_search_minus() {
        int[][] new_board = new int[two_pow_n][two_pow_n];

        for (int i = 0; i < Math.pow(2, n); i++) {
            for (int j = 0; j < Math.pow(2, n); j++) {
                if (board[i][j] == 0) continue;
                new_board[i][j] = minus(i, j);
            }
        }
        board = new_board;
    }

    static int minus(int y, int x) {

        int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 인접해 있는 칸 중에서 얼음이 3개나 4개가 있지 않으면, 얼음이 한칸 씩 줄어든다.
        int ice_block = 0;
        for (int d = 0; d < 4; d++) {
            int dy = y + delta[d][0];
            int dx = x + delta[d][1];
            if (check_out_of_index(dy, dx) && board[dy][dx] > 0) {
                ice_block += 1;
            }
        }
        if (ice_block < 3) {
            return board[y][x] - 1;
        } else {
            return board[y][x];
        }
    }

    static boolean check_out_of_index(int y, int x) {
        return 0 <= y && y < two_pow_n && 0 <= x && x < two_pow_n;
    }

    static int ice_sum() {
        int sum = 0;
        for (int i = 0; i < two_pow_n; i++) {
            for (int j = 0; j < two_pow_n; j++) {
                if (board[i][j] > 0) sum += board[i][j];
            }
        }
        return sum;
    }

    // 이 기법 외우기
    static int biggest_ice_class() {
        int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] isvisited = new boolean[two_pow_n][two_pow_n];
        int final_sum = 0;

        for (int i = 0; i < two_pow_n; i++){
            for (int j = 0; j < two_pow_n; j++){
                if (isvisited[i][j] || board[i][j] < 0) continue;
                int tmp_sum = 0;
                Deque<int[]> q = new ArrayDeque<>();
                q.addFirst(new int[] {i,j});
                while (!q.isEmpty()){
                    int[] poll = q.pollLast();
                    int y = poll[0];
                    int x = poll[1];

                    for (int d = 0; d < 4; d++){
                        int dy = y + delta[d][0];
                        int dx = x + delta[d][1];
                        if (!check_out_of_index(dy,dx) || isvisited[dy][dx] || board[dy][dx] <= 0) continue;
                        tmp_sum += 1;
                        isvisited[dy][dx] = true;
                        q.addFirst(new int[] {dy,dx});

                    }
                }
                if (final_sum < tmp_sum) final_sum = tmp_sum;
            }

        }
        return final_sum;
    }

    static void print_board(int[][] board) {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}




