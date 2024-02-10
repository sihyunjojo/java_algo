import java.io.*;
import java.util.*;


public class Swea_d4_1861_정사각형방 {
    static StringBuilder sb = new StringBuilder();
    static int n,board[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1861.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            List<Integer> result = new ArrayList<>();
            int max_count = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    int count = bfs(i, j);
                    if (max_count < count) {
                        max_count = count;
                        result = new ArrayList<>();
                        result.add(board[i][j]);
                    } else if(max_count == count) {
                        result.add(board[i][j]);
                    }
                }
            }
//            System.out.println("Result " + result);

            Collections.sort(result);
            sb.append(result.get(0)).append(" ").append(max_count).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs (int init_y, int init_x){
        int count = 1;
        int[][] delta = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[] isvisited = new boolean[n*n+1];

//        System.out.println(init_x+" "+ init_y);
        Deque<int[]> s = new ArrayDeque<>();
        s.add(new int[]{init_y, init_x});
        isvisited[board[init_y][init_x]] = true;

//        for (int[] ints : s) {
//            System.out.printf(Arrays.toString(ints));
//        }
//        System.out.println();
        while(!s.isEmpty()){
            int[] poll = s.pollLast();
            int y = poll[0];
            int x = poll[1];
//            System.out.println(n);
            for (int d = 0; d<4; d++){
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];
                if (0<= dy && dy < n && 0<= dx && dx<n && board[y][x]+1 == board[dy][dx] && !isvisited[board[dy][dx]]){
//                    System.out.println(board[dy][dx]);
                    count += 1;
                    s.addFirst(new int[]{dy,dx});
                }
            }
//            for (int[] ints : s) {
//                System.out.printf(Arrays.toString(ints));
//            }
//            System.out.println();
        }
        return count;
    }
}
