import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_Silver3_15651_n과m3 {
    static int[] arr;
    static int m,n;
    public static void main(String args[]) throws Exception {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        n = s.charAt(0) - '0';
        m = s.charAt(2) - '0';

        arr = new int[m];

        per(0);

    }
    private static void per(int count){
        if (count == m){
            for (int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++){
            arr[count] = i;
            per(count+1);
        }
    }
}
