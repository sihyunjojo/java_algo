import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 배열 돌리기 3
public class Bj_G5_16935_배열돌리기3 {
    static StringBuilder sb = new StringBuilder();
    static int n,m,r,board[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 수 (높이) (행의 수)
        m = Integer.parseInt(st.nextToken()); // 가로 수 (너비) (열의 수)
        r = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        printAll();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int commend = Integer.parseInt(st.nextToken());
            switch (commend){
                case 1:
                    a();
                    break;
                case 2:
                    b();
                    break;
                case 3:
                    c();
                    break;
                case 4:
                    d();
                    break;
                case 5:
                    e();
                    break;
                case 6:
                    f();
                    break;
            }
            n = board.length;
            m = board[0].length;
            printAll();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void a() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = board[(n-1-i)][j];
            }
        }
        board = temp;
    }
    private static void b() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = board[i][(m-1-j)];
            }
        }
        board = temp;
    }
    private static void c() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[n-1-j][i];
            }
        }
        board = temp;
    }
    private static void d() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[j][m-1-i];
            }
        }
        board = temp;

    }
    private static void e() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j+(m/2)] = board[i][j];
            }
        }
        for (int i = 0; i < n/2; i++) {
            for (int j = m/2; j < m; j++) {
                temp[i+(n/2)][j] = board[i][j];
            }
        }
        for (int i = n/2; i < n; i++) {
            for (int j = m/2; j < m; j++) {
                temp[i][j-(m/2)] = board[i][j];
            }
        }
        for (int i = n/2; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i-(n/2)][j] = board[i][j];
            }
        }
        board = temp;
    }
    private static void f() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i+(n/2)][j] = board[i][j];
            }
        }
        for (int i = 0; i < n/2; i++) {
            for (int j = m/2; j < m; j++) {
                temp[i][j-(m/2)] = board[i][j];
            }
        }
        for (int i = n/2; i < n; i++) {
            for (int j = m/2; j < m; j++) {
                temp[i-(n/2)][j] = board[i][j];
            }
        }
        for (int i = n/2; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j+(m/2)] = board[i][j];
            }
        }
        board = temp;
    }
    private static void printAll(){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}