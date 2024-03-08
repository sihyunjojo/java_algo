package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// for문으로 색칠하며 푸는 문제가 아니라.
// 4분면으로 나눈 뒤에
// 각각의 분면이 원하는 조건에 해당되는지 판단하고
// 그 분면이 조건에 해당되지 않으면 다시 4분면으로 나누는 방식으로 푸는 문제.

// 4개로 나누고 그 4개의 4개로 나누고 하면서 하나씩 클리어하는 문제.
// 해당되지 않으면 건드리지 않는 문제.

public class Bj_S1_1192_쿼드트리 {
    static int n,board[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        cal(0,0,n);

        System.out.println(sb);
    }

    private static void cal(int x, int y, int num){
        if (mini_cal(x,y,num)){
            sb.append(board[y][x]);
            return;
        }

        System.out.println(num);
        int size = num / 2;

        sb.append('(');

        cal(x,y,size);
        cal(x+size,y,size);
        cal(x,y+size,size);
        cal(x+size,y+size,size);

        sb.append(')');

    }

    private static boolean mini_cal(int x, int y, int n){
        System.out.println(y+" "+x);
        int color = board[y][x];

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++){
                if (board[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
