package bj;

import java.io.*;
import java.util.*;

//- 슬라이딩 윈도우 알고리즘을 이용하여 고정된 크기의 구간 결과를 계산
//- 단순 반복문을 통해 매번 문자열의 특정 구간 발생한 문자 개수를 세면 시간 초과 발생
public class B12891_My_TimeE {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int s_len = Integer.parseInt(st.nextToken());
        int p_len = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[][] counts = new int[][] {{'A',0},{'C',0},{'G',0},{'T',0}};

        for (int i = 0; i < 4; i++) {
            counts[i][1] = Integer.parseInt(st.nextToken());
        }


        loop:
        for (int i = 0; i < s_len - p_len + 1; i++){
            int[] tmp = new int[4];
            char[] temp = new char[p_len];
            System.arraycopy(arr, i , temp,0,p_len);
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < p_len; k++){
                    if (temp[k] == counts[j][0]){
                        tmp[j] += 1;
                    }
                }
                if (tmp[j] < counts[j][1]){
//                    System.out.println(j + " "+ counts[j][0] +" "+ counts[j][1]+" "+ tmp[j] +" " + Arrays.toString(temp));
                    continue loop;
                }
            }
            result += 1;
//            System.out.println(Arrays.toString(temp));
        }
        System.out.println(result);
    }
}
