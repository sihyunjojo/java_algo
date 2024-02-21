import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 모든 치킨집의 그거에 대해서 다 완탐하는 방식
//
public class Main {
    static int w, h;
    static int[][] board;
    static boolean isused[], isvisited[][];
    static ArrayList<int[]> house, chicken;
    static int[][] tmp_chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            String s = br.readLine();
            if (s.equals("0 0")) break;

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
            int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[] {0,0});

            while (!q.isEmpty()){
                int[] poll = q.poll();
                int y = poll[0];
                int x = poll[1];

                for (int d = 0; d <4; d++){

                }
            }

            System.out.println(res);
        }


    }
}
