import java.io.FileInputStream;
import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n,k,res,index;
    static int[][] board;
    static boolean[][] isvisited;
    static int[][][] make_board;
    static ArrayList<int[]> tops;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken()); // 하나의 집이 지불 할 수있는 비용.

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
            isvisited = new boolean[n][n];
            bfs(tops.get(i));
        }
    }
    static void bfs(int[] top){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(top);
        int max = 0;

        while (!q.isEmpty()){
            int[] poll = q.poll();

        }
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

