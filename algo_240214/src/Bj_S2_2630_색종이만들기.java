import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어떠한 동전들의 조합으로도 정확한 물건값이 될 수 없는 경우는 입력으로 주어지지 않는다.
// 그럼 뒤에서 부터 최대한 넣어주면 되지 않을까??

// 반복문을 뒤에서 생각하는 것 뿐만아니라.
// 전체의 결과가 있다면, 그 것을 반대로 구해서 마지막에 살짝만 계산하면 되는게 있다.

public class Bj_S2_2630_색종이만들기 {
    static int blue,white,n,board[][];
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

        count_paper(n);
        System.out.println(white);
        System.out.println(blue);
    }
    private static void count_paper(int num){
        for (int i = 0; i < n; i += num){
            for (int j = 0; j < n; j += num){
                count_blue(i,j,num);
                count_white(i,j,num);
            }
        }
        System.out.println("num = " + num);
        System.out.println(blue);
        System.out.println(white);
        for (int[] ints : board) System.out.println(Arrays.toString(ints));
        if (num == 1){
            return;
        }
        count_paper(num/2);
    }
    private static void count_blue(int x, int y, int n){
        int answer = 1;
        blue++;

        System.out.println("dddd " + x + " "+ y);
        loop:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++){
                if (board[i][j] != 1){
                    answer = 0;
                    blue--;
                    break loop;
                }
            }
        }

        if (answer == 1){
            for (int i = y; i < y + n; i++) {
                for (int j = x; j < x + n; j++){
                    board[i][j] = 2;
                }
            }
        }
    }
    private static void count_white(int x, int y, int n){
        int answer = 1;
        white++;

        loop:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++){
                if (board[i][j] != 0){
                    answer = 0;
                    white--;
                    break loop;
                }
            }
        }

        if (answer == 1){
            for (int i = y; i < y + n; i++) {
                for (int j = x; j < x + n; j++){
                    board[i][j] = 2;
                }
            }
        }
    }
}
