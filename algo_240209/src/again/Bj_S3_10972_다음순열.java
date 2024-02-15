package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_S3_10972_다음순열 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] input = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] init_input = Arrays.copyOf(input,n);
        boolean flag = true;

        int i = n-1;
        while(i>0 && input[i-1] >= input[i]) {
            --i;
        }
        if(i==0) {
            flag = false;
        }

        if (flag){
            int j=n-1;
            while(input[i-1]>=input[j])	--j;
            swap(input,i-1,j);

            int k = n-1;
            while(i<k) {
                swap(input,i++,k--);
            }

            flag = false;
            for (int aa = 0; aa < n; aa++){
                if (init_input[aa] != input[aa]){
                    flag = true;
                } sb.append(input[aa]).append(" ");
            }
        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
    private static void swap(int numbers[],int i,int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}