import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 핵심 아이디어는

public class J_P3_2543_타일채우기 {
    static int[][] board;
    static int[][][] delta = new int[][][]{
            {{0,1},{-1,1},{-1,0}},{{0,-1},{-1,0},{-1,-1}},{{1,0},{1,-1},{0,-1}},
            {{1,0},{1,1},{0,1}},{{0,1},{-1,0},{-1,1}},{{0,-1},{-1,-1},{0,-1}},
            {{0,1},{1,1},{1,0}},{{0,-1},{1,0},{1,-1}},{{-1,0},{-1,-1},{0,-1}},
            {{-1,0},{-1,1},{0,1}},{{1,0},{0,1},{1,1}},{{0, -1},{1, -1},{1,0}}
    };
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        board[y][x] = 0;

    }

    private static void dfs(){

    }

    private static boolean check(int x, int y){
        return x < 0;
    }
}

