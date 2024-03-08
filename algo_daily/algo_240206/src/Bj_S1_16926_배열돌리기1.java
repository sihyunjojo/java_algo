import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 돌리기1
// n과m이 다를 경우 90도 돌리고 돌리고 하는 알고리즘이 적용이 안되네...?
// 꺼꾸로 돌려야함
// 착실하게 돌리면 되는 문제이다.

public class Bj_S1_16926_배열돌리기1 {
    static StringBuilder sb = new StringBuilder();
    static int n,m,r,board[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        board = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int turn_num = Math.min(n,m) / 2;
        // 12  4
        // 13 4 -> 17 34 - 4 = 30   ->   11 2 -> 13 26 - 4 = 22
        for (int i = 0; i < turn_num; i++){
            int one_cycle = (n + m) * 2 - 4 - (i * 8);
            int turn_count = r % one_cycle;

            for (int j = 0; j < turn_count; j++) {
                int x = i;
                int y = i;
                int idx = 0;

                int tmp = board[y][x];
                while (idx < 4){
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if (i <= nx && nx < m - i && i <= ny && ny < n - i){
                        board[y][x] = board[ny][nx];
                        y = ny;
                        x = nx;
                    }
                    else {
                        idx++;
                        continue;
                    }
                }
                board[y+1][x] = tmp;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void prin(){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}