import java.io.FileInputStream;
import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n,m,res,index;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken()); // 하나의 집이 지불 할 수있는 비용.

            board = new int[n][n];
            res = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go();

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        index = n+1;
        while (index > 0){
            int index_cost = cal_cost(index);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count_house = count_house(i, j);
                    if (count_house * m >= index_cost && res < count_house) {
                        res = count_house;
                    }
                }
            }
            index--;
        }

    }
    static int count_house(int y, int x){
        int cnt = 0;
        for (int i = y - index < 0 ? 0 : y - index; i <= n; i++) {
            for (int j= x - index < 0 ? 0 : x - index; j <= n; j++) {
                if (check_size(i,j) && check_dis(y,x,i,j) && board[i][j] == 1){
                    cnt += 1;

                }
            }
        }
        return cnt;
    }
    static boolean check_dis(int y1, int x1, int y2,int x2){
        int dis = Math.abs(y1-y2) + Math.abs(x1-x2);
        return index > dis;
    }
    static int cal_cost(int k){
        return k * k + (k-1) * (k-1);
    }
    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

