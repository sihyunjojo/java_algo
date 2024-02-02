package bj;

import java.io.*;
import java.util.*;

// 윈도우 슬라이스 기법을 반드시 적용해야하는 문제
// 윈도우 슬라이스라는 기법이 자동으로 나오도록 잘 외워서 상기시켜 놓아야겠다.
public class B12891_Solve {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] arr,temp;
    static int s_len,p_len,counts[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        s_len = Integer.parseInt(st.nextToken());
        p_len = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        counts = new int[] {0,0,0,0};

        for (int i = 0; i < 4; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        temp = Arrays.copyOfRange(arr, 0 , p_len);

        init();
        for (int i = 0; i < s_len - p_len + 1; i++){
            System.out.println(Arrays.toString(counts));
            int flag = 0;
            for(int j = 0; j<4; j++){
                if (counts[j] <= 0){
                    flag++;
                }
            }
            if (flag == 4) result++;
            if (i == s_len-p_len) continue;
            remove(i);
            add(p_len+i);
        }
        System.out.println(result);
    }

    private static void init(){
        for (int i = 0; i < p_len; i++){
            if (temp[i] == 'A'){
                counts[0]--;
            }
            if (temp[i] == 'C'){
                counts[1]--;
            }
            if (temp[i] == 'G'){
                counts[2]--;
            }
            if (temp[i] == 'T'){
                counts[3]--;
            }
        }
    }
    private static void add(int end){
        if (arr[end] == 'A'){
            counts[0]--;
        }
        if (arr[end] == 'C'){
            counts[1]--;
        }
        if (arr[end] == 'G'){
            counts[2]--;
        }
        if (arr[end] == 'T'){
            counts[3]--;
        }
    }
    private static void remove(int start){
        if (arr[start] == 'A'){
            counts[0]++;
        }
        if (arr[start] == 'C'){
            counts[1]++;
        }
        if (arr[start] == 'G'){
            counts[2]++;
        }
        if (arr[start] == 'T'){
            counts[3]++;
        }
    }
}
