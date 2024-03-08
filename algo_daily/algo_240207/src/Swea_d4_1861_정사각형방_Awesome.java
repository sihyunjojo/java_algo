import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Swea_d4_1861_정사각형방_Awesome {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;
        int[] arr;
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            sb.append("#").append(testcase + 1).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = new int[N * N + 1];
            arr[0] = 10000000;
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[Integer.parseInt(st.nextToken())] = 1000 * i + j;
            }
            int idx = 0;
            int curlength = 1;
            int maxlength = 0;
            int diff;
            for (int i = N * N; i > 0; i--) {
                diff = arr[i] - arr[i - 1];
                if (diff == 1 || diff == 1000 ||diff == -1||diff == -1000)
                    curlength++;
                else {
                    if (curlength < maxlength) {
                        curlength = 1;
                        continue;
                    }
                    maxlength = curlength;
                    idx = i;
                    if (maxlength > i - 1)
                        break;
                    curlength = 1;
                }
            }
            sb.append(idx).append(" ").append(maxlength).append("\n");
        }
        System.out.print(sb);
    }
}