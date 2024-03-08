import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 모든 치킨집의 그거에 대해서 다 완탐하는 방식
//
public class Bj_S2_4963_섬의개수 {
    static int w, h;
    static int[][] board;
    static boolean isvisited[][];
    static ArrayList<int[]> house, chicken;
    static int[][] tmp_chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s.equals("0 0")) break;
//            System.out.println(s);
            st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
            isvisited = new boolean[h][w];

            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (board[i][j] == 1 && !isvisited[i][j]){
                        res += 1;
                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        q.add(new int[] {i,j});
                        isvisited[i][j] = true;


                        while (!q.isEmpty()){
                            int[] poll = q.poll();
                            int y = poll[0];
                            int x = poll[1];

                            for (int d = 0; d <8; d++){
                                int dy = y + delta[d][0];
                                int dx = x + delta[d][1];
//                                System.out.println(dy +" "+ dx);
                                if (check_size(dy,dx) && !isvisited[dy][dx] && board[dy][dx] == 1){
                                    q.add(new int[] {dy,dx});
                                    isvisited[dy][dx] = true;
                                }
                            }
//                            print_board(isvisited);
                        }

                    }
                }
            }
            System.out.println(res);
        }
    }
    static boolean check_size(int y , int x){
        return y >= 0 && x >= 0 && x < w && y < h;
    }
    static void print_board(boolean[][] board ){
        for (boolean[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
