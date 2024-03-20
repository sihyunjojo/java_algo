import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command){
                case 0:
                    union(a,b);
                    break;
                default:
                    System.out.println(checkUnion(a,b));
                    break;
            }
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
    }
    private static int find(int a) {
        if (arr[a] == a) return a;
        return find(arr[a]);
    }
    private static String checkUnion(int a, int b) {
        if ()
        return null;
    }
}