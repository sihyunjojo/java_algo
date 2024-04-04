import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
    static int res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input5643.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append(" ");

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] arr = new ArrayList[n+1];
            ArrayList<Integer>[] arr1 = new ArrayList[n+1];

            for (int j = 0; j < n+1; j++) {
                arr[j] = new ArrayList<>();
                arr1[j] = new ArrayList<>();

            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr[from].add(to);
                arr1[to].add(from);
            }

            int res = 0;
            for (int j = 1; j < n+1; j++) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(j);
                int cnt = 1;
                
                boolean[] isvisited = new boolean[n+1];
                isvisited[j] = true;
                
                while (!q.isEmpty()){
                    Integer now = q.poll();

                    for (Integer next : arr[now]) {
                        if (isvisited[next]) continue;
                        q.add(next);
                        isvisited[next] = true;
                        cnt++;
                    }
                }

                q.add(j);

                while (!q.isEmpty()){
                    Integer now = q.poll();

                    for (Integer next : arr1[now]) {
                        if (isvisited[next]) continue;
                        q.add(next);
                        isvisited[next] = true;
                        cnt++;
                    }
                }
                if (cnt == n) res++;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

}