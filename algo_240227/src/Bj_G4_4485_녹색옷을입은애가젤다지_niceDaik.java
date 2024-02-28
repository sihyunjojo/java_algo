import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 꼼꼼히 읽기.
public class Bj_G4_4485_녹색옷을입은애가젤다지_niceDaik {
    static class data implements Comparable<data>{
        int x;
        int y;
        int w;
        public data(int x, int y, int w) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(data o) {
            return w-o.w;
        }

        @Override
        public String toString() {
            return "data{" +
                    "x=" + x +
                    ", y=" + y +
                    ", w=" + w +
                    '}';
        }
    }
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    static int n;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 1;
        while(true){
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.printf("Problem %d: %d\n",t++,getMake());
        }
    }

    private static int getMake() {
        PriorityQueue<data> pq = new PriorityQueue<>();
        int[][] make = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                make[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.add(new data(0,0, board[0][0]));
        while (!pq.isEmpty()){
            data poll = pq.poll();

            for (int d = 0; d < 4; d++) {
                int dy = poll.y + delta[d][0];
                int dx = poll.x + delta[d][1];
                if (dy == n-1 && dx == n-1) return make[poll.y][poll.x] + board[dy][dx];

                if (check_size(dy, dx) && make[dy][dx] > poll.w + board[dy][dx]) {
                    make[dy][dx] = poll.w + board[dy][dx];
                    pq.add(new data(dx, dy, make[dy][dx]));
                }
            }
        }
        return 0;
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

