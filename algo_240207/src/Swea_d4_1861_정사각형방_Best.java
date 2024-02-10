import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea_d4_1861_정사각형방_Best {

    static class Room {
        int cnt;
        int value;

        public Room(int cnt, int value) {
            super();
            this.cnt = cnt;
            this.value = value;
        }

        public Room max(Room o) {
            if(cnt > o.cnt) {
                return this;
            }

            if(o.cnt > cnt) {
                return o;
            }

            return value > o.value ? o : this;
        }
    }

    static int n;
    static int[][] arr;
    static int[][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static Room ans;


    static boolean isOutOfIndex(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    static int dfs(int x, int y) {

        if(visited[y][x] != 0) {
            return visited[y][x];
        }

        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isOutOfIndex(nx,ny) || arr[y][x] + 1 != arr[ny][nx]) {
                continue;
            }

            cnt += dfs(nx,ny);
        }

        Room now = new Room(cnt, arr[y][x]);
        ans = now.max(ans);
        visited[y][x] = cnt;

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t < testCase + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            visited = new int[n][n];
            ans = new Room(-1,-1);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] == 0) {
                        dfs(j,i);
                    }
                }
            }

            bw.write(String.format("#%d %d %d\n", t,ans.value, ans.cnt));
        }

        bw.flush();
    }
}