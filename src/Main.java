import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 어떠한 동전들의 조합으로도 정확한 물건값이 될 수 없는 경우는 입력으로 주어지지 않는다.
// 그럼 뒤에서 부터 최대한 넣어주면 되지 않을까??

// 반복문을 뒤에서 생각하는 것 뿐만아니라.
// 전체의 결과가 있다면, 그 것을 반대로 구해서 마지막에 살짝만 계산하면 되는게 있다.

public class Main {
    static int n,board[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(n);
    }

    private static void cal(int num){
        for (int i = 0; i < n; i += num){
            for (int j = 0; j < n; j += num){
                mini_cal(i,j,num);
            }
        }

        if (num == 1){
            return;
        }
        cal(num/2);
    }

    private static void mini_cal(int x, int y, int n){
        int color = board[y][x];
        loop:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++){
                if (board[i][j] != color){
                    sb.append("()");
                    break loop;
                }
            }
        }
        sb.append(color);
    }
    private static void make_sb(String s,int num){

    }

}
