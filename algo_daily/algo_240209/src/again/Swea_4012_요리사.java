package again;

import java.io.*;
import java.util.*;

// 완전 구현인데... 아... 조합을 무슨 반복문에다 돌려서 무한 반복떠서 하...

public class Swea_4012_요리사 {
    static StringBuilder sb = new StringBuilder();
    static int board[][],arr[],temp[],flavors,n,result;
    static boolean isvisited[],isvisited2[];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input4012.txt"));
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


            result = Integer.MAX_VALUE;

            cal_best_result();
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    // 순서 상관 없고
    private static void cal_best_result(){
        isvisited2 = new boolean[n];
        arr = new int[n/2]; // 첫 음식에 들어가는 재료들 (절반)
        cal_result(0,0);
    }

    private static void cal_result(int count, int start){
        if (count == n/2){
            cal_flavors();
            return;
        }
        for (int i = start; i < n; i++){
            arr[count] = i;
            cal_result(count+1,i+1);
        }
    }


    // 조합
    private static void cal_flavors(){
        temp = new int[2];
        flavors = 0;
        cal_flavor(0,0);

        int temp1_flavor = flavors;

        int[] temp_arr = arr;
        int[] temp2 = new int[n/2];

        int index = 0;
        loop:
        for (int i2 = 0; i2 < n; i2++){
            for (int i1 : arr) {
                if (i1 == i2){
                    continue loop;
                }
            }
            temp2[index++] = i2;
        }

        arr = temp2;
        temp = new int[2];
        flavors = 0;

        cal_flavor(0,0);
        int temp2_flavor = flavors;

        int temp_result = Math.abs(temp1_flavor - temp2_flavor);
        if (result > temp_result) result = temp_result;
        arr = temp_arr;
    }
    private static void cal_flavor(int count,int start){
        if (count == 2){
            flavors += board[temp[0]][temp[1]] + board[temp[1]][temp[0]];
            return;
        }
        for (int i3 = start; i3 < n/2; i3++){
            temp[count] = arr[i3];
            cal_flavor(count+1,i3+1);
        }
    }
}


//1
//4
//0 5 3 8
//4 0 4 1
//2 5 0 3
//7 2 3 0