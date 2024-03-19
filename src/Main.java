import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
=======
    static int res;

>>>>>>> 0d8e12514b23cfeb4c062ca5d119a64cd8241216
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

<<<<<<< HEAD
        long[][] graph = new long[n+1][n+1];
        int a = 0;
        for (long[] line : graph) {
            Arrays.fill(line,Integer.MAX_VALUE);
            graph[a][a++] = 0;
        }

        for (long[] ints : graph) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (graph[from][to] > w){
                graph[from][to] = w;
            }
        }

        // 중간 점
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Integer.MAX_VALUE == graph[i][j]) {
                    System.out.println(0 + " ");
                    continue;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }



=======
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


>>>>>>> 0d8e12514b23cfeb4c062ca5d119a64cd8241216
    }
}