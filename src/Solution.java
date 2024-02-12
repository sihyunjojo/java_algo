import java.io.*;
import java.util.*;


public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int board[][],nums[],arr[],temp[],flavors,n;
    static boolean isvisited[];
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("inputFile/input4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            System.out.println(tc);
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());
            System.out.println(n);
            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int[] ints : board) {
                System.out.println(Arrays.toString(ints));
            }

            arr = new int[] {1,2,3};
            System.out.println(Arrays.toString(arr));
            cal_flavors();
            System.out.println(flavors);
//            int result = cal_result(n/2);

//            sb.append(result).append("\n");
        }
//        System.out.println(sb);
    }
    // 순서 상관 없고
    private static int cal_best_result(int num){
        int result = Integer.MAX_VALUE;
        arr = new int[num];

        while(true){
            if (arr.length == num){
                for (int i = 0; i < num; i++){

                }
            }
        }
        return result;
    }

    private static int cal_result(int count, int start){
        if (count == n/2){
            arr = temp;
            return cal_flavors()
        }
        for (int i = start; i < arr.length; i++){
            if (isvisited[i]) continue;
            isvisited[i] = true;
            temp[count] = arr[i];
            cal_flavor(count+1,i+1);
            isvisited[i] = false;
        }
    }

    // 조합
    private static void cal_flavors(){
        isvisited = new boolean[arr.length];
        temp = new int[2];
        int r = 2;
        cal_flavor(0,0,2);
    }
    private static void cal_flavor(int count,int start,int r){
        if (count == 2){
            return;
        }
        for (int i = start; i < arr.length; i++){
            if (isvisited[i]) continue;
            isvisited[i] = true;
            temp[count] = arr[i];
            cal_flavor(count+1,i+1,r);
            isvisited[i] = false;
        }
    }
}


//1
//4
//0 5 3 8
//4 0 4 1
//2 5 0 3
//7 2 3 0