import java.io.*;
import java.util.StringTokenizer;

//수열과 쿼리 17 실패
public class Main {
    static int res, n;
    static int[] arr, tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[getTreeSize(n)];
        treeInit(0, n - 1, 1);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (select == 1) {
                arr[first] = second;
            }
            if (select == 2) {
                int min = Integer.MAX_VALUE;
                for (int j = first; j <= second; j++) {
                    if (min > arr[j]) min = arr[j];
                }
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int treeInit(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(treeInit(start,mid,node*2), update(mid+1, end, node*2+1));
    }

    private static int update(int start, int end, int node) {

        return start;
    }

    private static int getTreeSize(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, h) - 1;
    }

}