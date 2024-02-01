package bj;

import java.io.*;
import java.util.*;

public class B3040 {
    static int[] arr = new int[9];
    static int[] result = new int[2];
    static int[] answer = new int[2];
    static int sum_values = 0;
    static boolean[] isVisited;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sum_values = 0;
        for (int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum_values += arr[i];
        }
        sum_values -= 100;

        isVisited = new boolean[9];

        per(0,0,sum_values);
        for (int i = 0; i < 9; i++){
            if (answer[0] != i && answer[1] != i){
                System.out.println(arr[i]);
            }
        }
    }


    private static void per(int count, int start, int sum_value){
        if (count == 2) {
            if (sum_value == 0){
                answer = Arrays.copyOf(result,count);
                return;
            }
            return;
        }
        for (int i = start; i < 9; i++){
            sum_value -= arr[i];
            result[count] = i;
            per(count+1,i+1, sum_value);
            sum_value += arr[i];
        }
    }
}
