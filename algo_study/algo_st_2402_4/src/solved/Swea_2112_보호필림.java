package solved;

import java.io.FileInputStream;
import java.io.*;
import java.util.*;


// 보호 필름
public class Swea_2112_보호필림 {
    static StringBuilder sb = new StringBuilder();
    static int d, w, k, res;
    static int[][] init_board, temp_board;
    static boolean isfinish;

    static int[] temp_combi_arr, temp_combi_drug_arr;

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

            init_board = new int[d][w];
            temp_board = new int[d][w];
            res = 0;

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    temp_board[i][j] = init_board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isfinish = false;
            go();
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        // 바꿀 수 있는 최대 수
        for (int i = 0; i < d; i++) {
            temp_combi_arr = new int[d];
            line_combination(i, 0, 0);
            if (isfinish) return;
        }
    }

    static void line_combination(int r, int count, int start) {
        if (count == r) {
            temp_combi_drug_arr = new int[r];
            drug_subset(r, 0);
            return;
        }
        for (int i = start; i < d; i++) {
            temp_combi_arr[count] = i;
            line_combination(r, count + 1, i + 1);
            if (isfinish) return;
        }
    }

    static void drug_subset(int r, int count) {
        if (count == r) {
            use_drug(r);
            return;
        }
        temp_combi_drug_arr[count] = 0;
        drug_subset(r, count + 1);
        if (isfinish) return;

        temp_combi_drug_arr[count] = 1;
        drug_subset(r, count + 1);
        if (isfinish) return;
    }

    //
    static void use_drug(int r) {
        for (int i = 0; i < r; i++) {
            Arrays.fill(temp_board[temp_combi_arr[i]], temp_combi_drug_arr[i]);
        }
        if (check_nice_product(temp_board)) {
            res = r;
            isfinish = true;
            return;
        }
        copy_board();
    }

    static boolean check_nice_product(int[][] board) {
//        print_board(board);
        int last_color = -1;
        int cnt = 0;
        int line_success = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < d; j++) {
                if (last_color == board[j][i]) {
                    cnt++;
                } else {
                    last_color = board[j][i];
                    cnt = 1;
                }
                if (cnt == k) {
//                    System.out.println(i+" "+j);
                    line_success++;
                    cnt = 0;
                    break;
                }
            }
            if (i + 1 != line_success) return false;
        }
        return true;
    }

    static void copy_board() {
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < w; j++) {
                temp_board[i][j] = init_board[i][j];
            }
        }
    }

//    static boolean check_size(int y , int x){
//        return 0 <= y && y < d && 0 <= x && x < w;
//    }

    static void print_board(int[][] board) {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
