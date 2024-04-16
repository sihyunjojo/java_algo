import java.io.*;
import java.util.*;

public class main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] in = new int[n+1];

        // n개의 문제를 전부 풀어야함.
        // 1번 문제가 가장 쉬운 문제임. -> 같은 조건일때는 숫자가 작은게 먼저 나와야함.
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 진입 차수 계산
            in[to]++;
            list[from].add(to);
        }

        for (int i = 1; i < n+1; i++) {
            list[i].sort(Comparator.naturalOrder());
        }

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (in[i] == 0) q.add(new int[] {i,0});
        }

        // 위상정렬하면됨.
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int
        }

    }
}