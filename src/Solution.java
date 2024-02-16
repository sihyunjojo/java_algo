import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[][][] board;
    static int m,a;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            int[][] user_move = new int[2][m];
            board = new int[10][10][a];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    user_move[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < a; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    for (int k = 0; k < c; k++){
                        for (int l = c; l > 0; l++){
                            board[y+k][x+l][i] = p;
                            board[y-k][x-l][i] = p;
                        }
                    }
                }
            }


        }
    }
    private static int cal_dis(int[] place1, int[] place2) {
        return Math.abs(place1[0]-place2[0]) + Math.abs(place1[1] - place2[1]);
    }

    private static boolean check(int y, int x){
        return 0 <= x && x < w && 0 <= y && y < h &&
                board[y][x] != '*' && board[y][x] != '#' && board[y][x] != '-';
    }
}