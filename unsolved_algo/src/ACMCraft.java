import java.io.*;
import java.util.*;

public class ACMCraft {
    static int n, end;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            for (int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList[n+1];
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
                dis[to]++;
            }

            end = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j < n + 1; j++) {
                if(dis[j] == 0){
                    list.add(go(j));
                }
            }
            list.sort(Comparator.reverseOrder());
            sb.append(list.get(0)).append("\n");
        }
        System.out.println(sb);
    }
    static int go(int start){
        Queue<int[]> q = new PriorityQueue<>((o1,o2) -> {
            if (o1[0] == o2[0]) return -(o1[2] - o2[2]);
            return -(o1[0] - o2[0]);
        });

        q.offer(new int[] {0, start, arr[start]});
        int[] dis = new int[n+1];

        loop:
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int now_dis = poll[0];
            int now = poll[1];
//            System.out.println(Arrays.toString(poll));
//            if (now == end) break loop;

            if (dis[now] > now_dis) continue;

            for (int next : list[now]) {
                if (dis[next] >= arr[now] + now_dis) continue;
                dis[next] = arr[now] + now_dis;
                q.offer(new int[] {dis[next], next, arr[next]});
            }
        }

        return dis[end]+arr[end];
    }

}