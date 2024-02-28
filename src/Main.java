import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n,m,cnt;
    static int[][] board;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        cnt = 0;
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6){
                    arr.add(new int[] {i,j});
                }
            }
        }

        dfs();
        System.out.println(cnt);
    }

    public static void dfs(int cctv_cnt, int[][] temp_board){
        if (cctv_cnt == arr.size()){
            temp_board
        }
    }

    public static void checkLeft(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }
    public static void checkRight(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }
    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }
    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    static void count_watch(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == )
            }
        }
    }
}

