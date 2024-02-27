import java.io.FileInputStream;
import java.io.*;
import java.util.*;


// 보호 필름
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n,k,res,index;
    static int[][] board;
    static boolean[][][] isvisited;
    static int[][][] make_board;
    static ArrayList<int[]> tops;
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            tops = new ArrayList<>();
            int max_top = 0;
            res = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (max_top < board[i][j]) {
                        max_top = board[i][j];
                        tops.clear();
                    }
                    if (max_top == board[i][j]) tops.add(new int[] {i,j});
                }
            }


            go();

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        for (int i = 0; i < tops.size(); i++){
            isvisited = new boolean[2][n][n];
            make_board = new int[2][n][n];
            bfs(tops.get(i));
        }
    }
    static void bfs(int[] top){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {top[0],top[1],1,0});
        make_board[0][top[0]][top[1]] = 1;
        make_board[1][top[0]][top[1]] = 1;
        isvisited[0][top[0]][top[1]] = true;
        isvisited[1][top[0]][top[1]] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int is_break = poll[2];
            int last_block = poll[3];

            for (int d = 0; d < 4; d++){
                int dx = x + delta[d][1];
                int dy = y + delta[d][0];
                if (check_size(dy,dx)){
                    if (board[dy][dx] < board[y][x]){
                        if(is_break == 1 && make_board[0][dy][dx] == 0){
                            q.add(new int[] {dy,dx,is_break,0});
                            make_board[0][dy][dx] = make_board[0][y][x] + 1;
                        }
                        if (is_break == 0  && make_board[1][dy][dx] < make_board[1][y][x]){
                            System.out.println(y + " " + x + " " + dy+ " " +dx + " "+board[dy][dx] + " " +board[y][x] + " " +last_block);
                            if (last_block <= board[dy][dx]) continue;
                            make_board[1][dy][dx] = make_board[1][y][x] +1;
                            if (last_block != board[dy][dx]) q.add(new int[] {dy,dx,is_break,board[dy][dx]});
                            System.out.println(dy+ " " +dx + " "+board[dy][dx] + " " +board[y][x]);
                            q.add(new int[] {dy,dx,is_break,board[dy][dx]});

                        }

                    }
                    // 부숨
                    if (board[dy][dx] <= board[dy][dx] && is_break == 1  && make_board[1][dy][dx] < make_board[0][y][x]){
                        if (board[y][x] - board[dy][dx] >= k) continue;
                        q.add(new int[] {dy,dx,0,board[y][x]-1});
                        make_board[1][dy][dx] = make_board[0][y][x] + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(top));
        print_board(board);
        print_board(make_board[0]);
        print_board(make_board[1]);
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    static void print_board(int[][] board){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
