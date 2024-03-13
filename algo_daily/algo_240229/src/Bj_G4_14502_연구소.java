import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Bj_G4_14502_연구소 {
    static class Point{
        int x,y,index;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
            this.index = 10 * y + x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", index=" + index +
                    '}';
        }
    }
    static int n,m, res, all_blank;
    static int[][] board;
    static boolean[][] isvisited;
    static int[] temp_arr;
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Point> points, viruss;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        points = new ArrayList<Point>();
        viruss = new ArrayList<Point>();
        all_blank = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0){
                    points.add(new Point(i,j));
                    all_blank++;
                }
                if (board[i][j] == 2){
                    viruss.add(new Point(i,j));
                }
            }
        }
        res = Integer.MAX_VALUE;

        temp_arr = new int[3];
        combination(0,0);

        System.out.println(all_blank - res-3);
    }

    static void combination(int count, int start){
        if (count == 3){
            isvisited = new boolean[n][m];
            bfs();
            return;
        }
        for (int i = start; i < points.size(); i++){
            temp_arr[count] = i;
            combination(count+1,i+1);
        }
    }

    static void bfs() {
        int cnt = 0; // 바이러스가 옮긴 곳. (안전구역이 아닌곳) // 최저가 되야함.
        ArrayDeque<int[]> q = new ArrayDeque();

        for (int i = 0; i < 3; i++){
            Point point = points.get(temp_arr[i]);
            isvisited[point.y][point.x] = true;
        }

        for (Point virus : viruss) {
            q.add(new int[]{virus.y, virus.x});
            isvisited[virus.y][virus.x] = true;
        }

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for (int d = 0; d < 4; d++){
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];

                if (check_size(dy,dx) && !isvisited[dy][dx] && board[dy][dx] != 1){
                    isvisited[dy][dx] = true;
                    q.add(new int[] {dy,dx});
                    cnt++;
                    if (cnt >= res) return;
                }
            }
        }

        res = cnt;
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}


