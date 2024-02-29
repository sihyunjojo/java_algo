import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Person{
        int x,y,index;

        public Person(int y, int x) {
            this.x = x;
            this.y = y;
            this.index = 10 * y + x;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "x=" + x +
                    ", y=" + y +
                    ", index=" + index +
                    '}';
        }
    }
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        idasom = new ArrayList<>();
        board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken().charAt(0);

            }
        }

        // 이다솜파 4명을 끼우고 그다음을 아무나 끼우면 되잖아.
        temp_arr = new int[7];
        combination(0,0);

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
//        Point{x=4, y=0, index=4}
//        Point{x=3, y=1, index=13}
        res = cnt;
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}


