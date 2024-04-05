import java.io.*;
import java.util.*;
<<<<<<< HEAD

public class Main{
    static int cnt,r,c;
    static StringBuilder sb = new StringBuilder();
    static char[][] board;
    static int[][] delta = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    static int[] arr;
    static boolean[][] isvisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r+1][c];
        cnt = 0;
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'x'){
                    cnt++;
=======

public class Main {
    static int n, end;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        System.out.println();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList[n + 1];
            int[] condition_make = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }

            int[] dis = new int[n + 1];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                dis[to]++;
            }

            end = Integer.parseInt(br.readLine());

            Queue<int[]> q = new ArrayDeque<>();

            for (int j = 1; j < n+1; j++) {
                if (dis[j] == 0){
                    q.add(new int[] {j});
>>>>>>> 7bbae4f7d62bb44cca56bc590d0fe4179cb8ab3d
                }
            }
        }
        Arrays.fill(board[r],'x');

<<<<<<< HEAD
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            delete(i);
            check_down();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void check_down() {
        // 띄워진 구간이 있다 == 내려 줘야한다
        isvisited = new boolean[r+1][c];

        if (cnt != bfs(r,0)){
            loop:
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == 'x'){
                        if (isvisited[i][j]) continue;
                        down(i,j);
                        break loop;
                    }
                }
            }
        }
    }

    private static void down(int i, int j) {
        int[] arr = new int[c];

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        isvisited[i][j] = true;

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {i,j});


        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            if(arr[x] < y) arr[x] = y;

            for (int d = 0; d < 4; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];
                if (!checkSize(dy,dx)) continue;
                if (isvisited[dy][dx]) continue;
                if (board[dy][dx] == '.') continue;
                q.add(new int[] {dy,dx});
                list.add(new int[] {dy,dx});
                isvisited[dy][dx] = true;
            }
        }

        System.out.println(Arrays.toString(arr));
        int tmp = 1;
        loop:
        while (true){
            for (int k = 0; k < c; k++) {
                if (arr[k] == 0) continue;
                System.out.println(arr[k]+tmp);
                System.out.println(k);
                if (board[arr[k]+tmp][k] == 'x'){
                    break loop;
                }
            }
            tmp++;
        }

        for (int[] ints : list) {
            board[ints[0]][ints[1]] = '.';
        }
        for (int[] ints : list) {
            board[ints[0]+tmp-1][ints[1]] = 'x';
        }
    }

    private static int bfs(int i, int j){

        int cnt = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        isvisited[i][j] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            cnt++;

            for (int d = 0; d < 4; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];
                if (!checkSize(dy,dx)) continue;
                if (isvisited[dy][dx]) continue;
                if (board[dy][dx] == '.') continue;

                q.add(new int[] {dy,dx});
                isvisited[dy][dx] = true;
            }
        }
        return cnt-c;
    }

    static boolean checkSize(int y, int x){
        return 0 <= y && y < r+1 && 0 <= x && x < c;
    }

    private static void delete(int i) {
        // 오른쪽에서
        int shoot = r - arr[i];
        if(i % 2 == 0){
            for (int j = 0; j < c; j++) {
                if (board[shoot][j] == 'x'){
                    board[shoot][j] = '.';
                    cnt--;
                    break;
                }
            }
        }
        // 왼쪽에서
        else {
            for (int j = c-1; j >= 0; j--) {
                if (board[shoot][j] == 'x'){
                    board[shoot][j] = '.';
                    cnt--;
                    break;
                }
            }
        }
    }

    static void printBoard(){
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }
=======
            System.out.println();
            int[] dp = new int[n+1];
            boolean[] isvisited = new boolean[n+1];
>>>>>>> 7bbae4f7d62bb44cca56bc590d0fe4179cb8ab3d

            while (!q.isEmpty()){
                int[] now = q.poll();
                int now_point = now[0];

                System.out.println(Arrays.toString(now));
//                if (isvisited[now_point]) continue;
//                isvisited[now_point] = true;

                for (int next : list[now_point]) {
                    if (dp[next] >= arr[now_point] + dp[now_point]) continue;
                    dp[next] = arr[now_point] + dp[now_point];
                    q.add(new int[] {next});
                    System.out.println(Arrays.toString(dp));
                }
            }

            sb.append(dp[end]+arr[end]).append("\n");
        }
        System.out.println(sb);
    }
}