// 로또
import java.io.*;
import java.util.*;

public class Bj_S3_6603_로또 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isvisited;
    static int[] arr,temp;
    final static int max_count = 6;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n==0){
                break;
            }
            arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            isvisited = new boolean[n];

            per("",0,0);
            bw.newLine();
        }
        bw.flush();
    }
    private static void per(String str, int count, int start) throws IOException {
        if (count == max_count){
            bw.write(str + "\n");
            return;
        }
        for (int i = start; i < n; i++){
            if (isvisited[i]) continue;
            isvisited[i] = true;
            per(str + arr[i] + " ",count+1, i+1);
            isvisited[i] = false;
        }
    }
}
