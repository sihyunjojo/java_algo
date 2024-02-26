package def;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj_S3_2606_바이러스 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(br.readLine());
        int aaa = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i]= new ArrayList<>();
        }

        for (int i = 0; i < aaa; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            arr[to].add(from);
            arr[from].add(to);
        }

        int res = 0;
        boolean[] isvisited = new boolean[n+1];

        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        isvisited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < arr[now].size(); i++) {
                int next = arr[now].get(i);
                if (isvisited[next]) continue;
                isvisited[next] = true;
                res += 1;
                q.add(next);
            }
        }
        System.out.println(res);
    }
}
