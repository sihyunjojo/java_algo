import java.io.*;
import java.util.*;
import java.util.Arrays;

// 음주 코딩
public class Main {
    static int res, n;
    static int[] arr, tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[getTreeSize(n)];
        treeInit(0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String select = st.nextToken();
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;

            if (select.equals("C")) {
                arr[first] = second + 1;
                update(0,n-1,1,first);
            }
            if (select.equals("P")) {
              sb.append(getResult()).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static char getResult() {
        return null;
    }

    private static int treeInit(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
,
        return tree[node] = Math.min(treeInit(start, mid, node * 2),
                treeInit(mid + 1, end, node * 2 + 1));
    }

    private static int update(int start, int end, int node, int idx) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) return tree[node] = arr[idx];

        int mid = (start + end) / 2;

        return tree[node] = Math.min(update(start, mid, node * 2, idx),
                update(mid + 1, end, node * 2 + 1, idx));
    }

    private static int getTreeSize(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, h) - 1;
    }
}