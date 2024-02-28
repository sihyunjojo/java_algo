import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Bj_G4_15683_감시 {
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n,m,res;
    static int[][] board;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5){
                    arr.add(new int[]{i,j});
                }
            }
        }

        res = Integer.MAX_VALUE;
        int[][] temp_board = copy_board(board);
        dfs(0, temp_board);

        System.out.println(res);
    }

    public static void dfs(int cctv_cnt, int[][] temp_board){
        if (cctv_cnt == arr.size()){
            count_watch(temp_board);
            print_board(temp_board);
            return;
        }
        int[] ints = arr.get(cctv_cnt);
        int x = ints[1];
        int y = ints[0];
        int what_cctv = board[y][x];
        int[][] init_board = copy_board(temp_board);

        switch (what_cctv){
            case 1:
                checkLeft(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkRight(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkUp(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                break;
            case 2:
                checkLeft(temp_board,x,y);
                checkRight(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkUp(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                break;
            case 3:
                checkRight(temp_board,x,y);
                checkUp(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkLeft(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkRight(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkLeft(temp_board,x,y);
                checkUp(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                break;
            case 4:
                checkRight(temp_board,x,y);
                checkUp(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkLeft(temp_board,x,y);
                checkUp(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkLeft(temp_board,x,y);
                checkRight(temp_board,x,y);
                checkDown(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                temp_board = copy_board(init_board);

                checkLeft(temp_board,x,y);
                checkRight(temp_board,x,y);
                checkUp(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
                break;
            default:
                checkRight(temp_board,x,y);
                checkUp(temp_board,x,y);
                checkDown(temp_board,x,y);
                checkLeft(temp_board,x,y);
                dfs(cctv_cnt+1,temp_board);
        }
    }


    public static void checkLeft(int[][] map, int x, int y) {
        for(int i=x-1; i >= 0; i--) {
            if(map[y][i] == 6) return;
            if(map[y][i] != 0) continue;
            map[y][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for(int i=x+1; i<m; i++) {
            if(map[y][i] == 6) return;
            if(map[y][i] != 0) continue;
            map[y][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[i][x] == 6) return;
            if(map[i][x] != 0) continue;
            map[i][x] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=y+1; i<n; i++) {
            if(map[i][x] == 6) return;
            if(map[i][x] != 0) continue;
            map[i][x] = -1;
        }
    }

    static int[][] copy_board(int[][] board){
        int[][] new_board = new int[n][m];
        for (int i = 0; i < n; i++) {
            new_board[i] = Arrays.copyOf(board[i],m);
        }
        return new_board;
    }

    static void count_watch(int[][] board){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0){
                    cnt += 1;
                }
            }
        }
        if (res > cnt) res = cnt;
    }

    static void print_board(int[][] board){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(

        );
    }
}

