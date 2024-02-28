import java.io.FileInputStream;
import java.io.*;
import java.util.*;


// 보호 필름
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int d,w,k,res;
    static int[][] board;
    static int[] temp_combi_arr;
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            res = 0;

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            go();

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        // 바꿀 수 있는 최대 수
        for (int i = 0; i < d; i++){
            temp_combi_arr = new int[d];
            line_combination(i,0,0);
        }
    }
    static void line_combination(int r,int count, int start){
        if (count == r){
            drug_subset(r,0);
            return;
        }
        for (int i = start; i < d; i++){
            temp_combi_arr[count] = i;
            line_combination(r,count+1,i+1);
        }
    }
    static void drug_subset(int r, int count){
        if (count == r){
            use_drug();
            return;
        }

    }

    //
    static void use_drug(){

    }

    static boolean check_nice_product(){
        int last_color = -1;
        int cnt = 0;
        int line_success = 0;
        for (int i = 0; i < w; i++){
            for (int j = 0; j < d; j++){
                if (last_color == board[j][i]){
                    cnt++;
                } else {
                    last_color = board[j][1];
                    cnt++;
                }
                if (cnt == k){
                    line_success++;
                    break;
                }
            }
            if (i+1 != line_success) return false;
        }
        return true;
    }

    static boolean check_size(int y , int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    static void print_board(int[][] board){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
