import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj_KMPcraft {
    static int res;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            for (int j = 1; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] list = new ArrayList[n+1];
            int[] condition_make = new int[n+1];
            for (int j = 0; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }

            int[] dis = new int[n+1];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);

                // 건물 조건들 저장.. 음.. 그냥 가장 큰거 저장 해도 되려나?
                condition_make[to] = Math.max(condition_make[to],arr[from]);
                dis[to]++;
            }

            int end = Integer.parseInt(br.readLine());

            boolean[] ismake = new boolean[n+1];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int j = 1; j < n + 1; j++) {
                if(dis[j] == 0){
                    q.add(j);
                }
            }

            while (!q.isEmpty()){
                Integer now = q.poll();
            }
            // 같은 게 있다면 둘 중에 비교해서 더 큰거 넣어줌.
        }
    }

}