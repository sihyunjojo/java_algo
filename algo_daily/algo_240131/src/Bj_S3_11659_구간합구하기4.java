import java.io.*;
import java.util.*;

public class Bj_S3_11659_구간합구하기4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for (int i =0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write( arr[b] - arr[a-1] + "\n");
        }
        bw.flush();
    }
}


// arr[0] = 0
// arr[1] = 0 + output[1]
// arr[2] = o[1] + o[2]