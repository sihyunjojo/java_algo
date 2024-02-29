import java.io.FileInputStream;
import java.io.*;
import java.util.*;


public class Swea_1767_프로세서연결하기 {

    static class Core{
        int x,y;
        ArrayList<Integer> dirs = new ArrayList<>();

        public Core(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Core{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dirs=" + dirs +
                    '}';
        }
    }

    static int[][] delta = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    static StringBuilder sb = new StringBuilder();
    static int n, res,temp_res;
    static int[][] init_board, temp_board;
    static ArrayList<Core> cores;
    static int[] temp_combi_arr, temp_combi_dir_arr;

    public static void main(String[] args) throws IOException {
//            System.setIn(new FileInputStream("InputFile/input1767.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int tc = Integer.parseInt(br.readLine());

            for (int t = 1; t <= tc; t++) {

                sb.append("#").append(t).append(" ");
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                init_board = new int[n][n];
                temp_board = new int[n][n];
                cores = new ArrayList<>();
                res = 200;

                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        temp_board[i][j] = init_board[i][j] = Integer.parseInt(st.nextToken());
                        if (init_board[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                            cores.add(new Core(i, j));
                        }
                    }
                }

                for (Core core : cores) {
                    int x = core.x;
                    int y = core.y;

                    loop:
                    for (int d = 0; d < 4; d++) {
                        int dx = x + delta[d][1];
                        int dy = y + delta[d][0];
                        while (check_size(dy, dx)) {
                            if (init_board[dy][dx] == 1) {
                                continue loop;
                            }
                            dy += delta[d][0];
                            dx += delta[d][1];
                        }
                        // 상하좌우 방향으로 돌려서
                        core.dirs.add(d);
                    }
                }

//            for (Core core : cores) {
//                System.out.println(core);
//            }
                go();

                sb.append(res).append("\n");
            }
            System.out.println(sb);
    }

    static void go() {
        // 바꿀 수 있는 최대 수
        for (int i = cores.size(); i > 0; i--) {
            temp_combi_arr = new int[i];
            temp_res = 200;

            line_combination(i,0,0);

            if (res != temp_res) {
                res = temp_res;
                return;
            }
        }
    }

    static void line_combination(int r, int count, int start) {
        if (count == r) {
            temp_combi_dir_arr = new int[r];
            dfs(r, 0);
            return;
        }
        for (int i = start; i < cores.size(); i++) {
            temp_combi_arr[count] = i;
            line_combination(r, count + 1, i + 1);
        }
    }

    static void dfs(int r, int count) {
        if (count == r) {
//            System.out.println(Arrays.toString(temp_combi_dir_arr));
            int cnt = check_line(r);
            if (temp_res > cnt) temp_res = cnt;
            return;
        }
        int core_index = temp_combi_arr[count];
        Core core = cores.get(core_index);

        for (int i = 0; i < core.dirs.size(); i++) {
            temp_combi_dir_arr[count] = core.dirs.get(i);
            dfs(r,count+1);
        }
    }

    //
    static int check_line(int r) {
//        print_board(temp_board);
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            Core core = cores.get(temp_combi_arr[i]);
            int dy = core.y + delta[temp_combi_dir_arr[i]][0];;
            int dx = core.x + delta[temp_combi_dir_arr[i]][1];;
            while (check_size(dy,dx)){
                if (temp_board[dy][dx] != 0){
//                    System.out.println(dy+" " + dx);
//                    System.out.println(cnt);
//                    System.out.println(i);
                    // 있어서는 안되는 경우 가장 큰 값으로 리턴함.
                    copy_board();
                    return Integer.MAX_VALUE;
                }
                if (temp_board[dy][dx] == 0){
                    temp_board[dy][dx] = -1;
                    cnt += 1;
                }
                dy += delta[temp_combi_dir_arr[i]][0];
                dx += delta[temp_combi_dir_arr[i]][1];
            }
        }
        copy_board();
        return cnt;
    }// 우 우 상 하 하
    // 3 3 0 1 1

    static void copy_board() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp_board[i][j] = init_board[i][j];
            }
        }
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    static void print_board(int[][] board) {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
// 시간차이(ms) : 0.004948
// 0.169830
