package fail;

import java.io.*;
import java.util.*;

// 순열의 함정에 빠지지 말자.

public class Swea_4008_숫자만들기_Good {
    static StringBuilder sb = new StringBuilder();
    static int[] operands, operators, temp_operator, cnt_operators;
    static int min_res,max_res,n;
    static boolean[] isvisited;
    static int cont;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input4008.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            n = Integer.parseInt(br.readLine());

            operators = new int[n-1];
            cnt_operators = new int[4];
            int k = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                int operator_cnt = Integer.parseInt(st.nextToken());
                cnt_operators[i] = operator_cnt;
                for (int j = 0; j < operator_cnt; j++){
                    operators[k++] = i;
                }
            }

            operands = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                operands[i] = Integer.parseInt(st.nextToken());
            }

            isvisited = new boolean[n-1];
            min_res = Integer.MAX_VALUE;
            max_res = Integer.MIN_VALUE;

            cont = 0;
            temp_operator = new int[n-1];
            go(0, operands[0]);
            sb.append(max_res-min_res).append("\n");
            System.out.println(cont);
        }
        System.out.println(sb);
    }

    // 조합
    static void go(int count,int result){
        if (count == n-1){
            if (max_res < result) max_res = result;
            if (min_res > result) min_res = result;
            return;
        }

        for (int i = 0; i<4; i++){
            int last_res = result;
            if (cnt_operators[i] == 0) continue;
            isvisited[i] = true;
            result = cal(result, operands[count+1], operators[i]);
            go(count+1, result);
            result = last_res;
            isvisited[i] = false;
        }
    }

    static int cal(int o1, int o2, int operator){
        switch (operator){
            case 0:
                return o1+o2;
            case 1:
                return o1-o2;
            case 2:
                return o1*o2;
            default:
                return o1/o2;
        }
    }
}
//5
//2 1 0 1
//3 5 3 7 9