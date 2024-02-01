package bj;

import java.io.*;
import java.util.*;

public class B2961 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, result, foods[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        result = Integer.MAX_VALUE;
        foods = new int[n][2];

        for (int i= 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Integer.parseInt(st.nextToken());
            foods[i][1] = Integer.parseInt(st.nextToken());
        }
        cal(0,1,0);

        System.out.println(result);
    }
    private static void cal(int count,int s_flavor, int ss_flavor) {
        if (count == n){
            if (result > Math.abs(s_flavor - ss_flavor) && ss_flavor != 0) {
                result = Math.abs(s_flavor - ss_flavor);
            }
            return;
        }
        cal(count + 1, s_flavor, ss_flavor);
        cal(count + 1,
                s_flavor * foods[count][0],
                ss_flavor + foods[count][1]);
    }
}
