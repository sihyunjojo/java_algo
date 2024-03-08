import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 꼼꼼히 읽기.
public class Bj_G4_4485_녹색옷을입은애가젤다지 {
    static StringBuilder sb = new StringBuilder();
    static int n,res;
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    static boolean[][] isvisited;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 1;
        while(true){
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append("Problem ").append(t++).append(": ");

            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            isvisited = new boolean[n][n];
            isvisited[0][0] = true;

            res = Integer.MAX_VALUE;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.add(new int[] {0,0,board[0][0]});
            isvisited[0][0] = true;

            loop:
            while (!pq.isEmpty()){
                int[] poll = pq.poll();
                int y = poll[0];
                int x = poll[1];
                int money = poll[2];
//                System.out.println(money);

                for (int d = 0; d < 4; d++) {
                    int dy = y + delta[d][0];
                    int dx = x + delta[d][1];
                    if (check_size(dy, dx) && !isvisited[dy][dx]) {
                        if (dy == n - 1 && dx == n - 1) {
                            res = money + board[n - 1][n - 1];
                            break loop;
                        }
                        pq.add(new int[]{dy, dx, money + board[dy][dx]});
                        isvisited[dy][dx] = true;
                    }

                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

