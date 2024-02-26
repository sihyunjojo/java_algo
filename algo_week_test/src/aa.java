package abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo1_구미_4반_조시현 {
    static int[] arr;
    static StringBuilder sBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sBuilder.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            arr = new int[n+1];
            for (int i = 0; i <= n; i++) {
                arr[i] =  i;
            }

            for (int i = 0; i < k; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(stringTokenizer.nextToken());
                int n2 = Integer.parseInt(stringTokenizer.nextToken());
                suffle(n1, n2);
            }

            int res = 0;
            for (int i = 0; i < n+1; i++) {
                if (arr[i] == x) {
                    res = i;
                    break;
                }
            }

            sBuilder.append(res).append("\n");
        }
        System.out.println(sBuilder);

    }
    static void suffle(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
