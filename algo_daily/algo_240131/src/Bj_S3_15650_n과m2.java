import java.io.*;

// n과 m(2) 조합
public class Bj_S3_15650_n과m2 {
    static int[] temp;
    static boolean[] isvisited;
    static int n,m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.charAt(0)-'0';
        m = s.charAt(2)-'0';

        isvisited = new boolean[n+1];
        temp = new int[m];

        per("",0,1);
        bw.flush();
    }
    private static void per(String str, int count, int start) throws IOException {
        if (count == m){
            bw.write(str + "\n");
            return;
        }
        for (int i = start; i <= n; i++){
            if (isvisited[i]) continue;
            per(str + i + " ",count+1, i+1);
        }

    }
}
