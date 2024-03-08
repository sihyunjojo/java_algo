package fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Swea_1949_등산로조성_Best {
 
    static int N,K,result;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            board = new int[N][N];
            int max = 0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j] > max) max = board[i][j];
                }
            } // input end

            result = 0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(board[i][j] == max) { // 봉우리면
                        visited[i][j] = true;
                        solve(i, j,max, 1, 0);
                        visited[i][j] = false;
                    }
                }
            }
             
            sb.append("#"+tc+" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void solve(int x, int y, int cur, int cnt, int flag) {
        result = Math.max(result, cnt);
 
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
             
            if(!check_range(nx, ny)) continue;
             
            if(visited[nx][ny]) continue;

            // 끝까지가서 찍고 거기 최고 값 갱신하고
            if(board[nx][ny] < cur) {
                visited[nx][ny] = true;
                solve(nx,ny,board[nx][ny],cnt+1,flag);
                visited[nx][ny] = false;
            }


            else {
                if(flag == 0) { // 안 뿌섯으면
                    if(board[nx][ny]-K < cur) {
                        visited[nx][ny] = true;
                        // 뿌서주고 늘리고 줄이고
                        solve(nx, ny,cur-1, cnt+1,flag+1);
                        visited[nx][ny] = false;
                    }
                }
            }
             
        }
    }
 
    private static boolean check_range(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}