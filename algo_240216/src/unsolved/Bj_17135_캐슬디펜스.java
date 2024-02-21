package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 꼼꼼히 읽기.
public class Main {
    static int n,m,d,res;
    static boolean[] isused;
    static boolean[][] isvisited;
    static int[] temp_archers;
    static int[][] init_board,temp_board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        res = 0;

        init_board = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                init_board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isused = new boolean[m];
        temp_archers = new int[3];

        c(0,0);

        System.out.println(res);
    }

    static void c(int count,int start){
        if (count == 3){
            print_board(temp_board);
            int go = go(temp_archers);
            if (res < go) res = go;
            System.out.println(
            );
            return;
        }
        for (int i = start; i < m; i++){
            if (isused[i]) continue;
            isused[i] = true;
            temp_archers[count] = i;
            c(count+1,i+1);
            isused[i] = false;
        }
    }
    static int go(int[] archers) {
    }

    static int cal_dis(int[] en,int[] archer){
        return Math.abs(en[1] - archer[1]) + Math.abs(en[0] - archer[0]);
    }
    static boolean check_size(int y, int x){
        return 0 <= x && 0 <= y && x < m && y < n;
    }
    static void print_board(int[][] board){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}

