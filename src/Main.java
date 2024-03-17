import javax.swing.text.html.ListView;
import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 너무너무너무너무너무 어려움
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr[n-1];

        while (left < right){
            int mid = (left + right) / 2;

            int sum = n-1;

            for (int i = 0; i < n - 1; i++) {
                sum -= (arr[i+1] - arr[i] - 1) / mid;
            }
            System.out.println("sum = "+sum);

            if (sum < m-1) {
                left = mid +1;
            } else {
                right = mid;
            }
            System.out.println("mid = " + mid);
        }

        System.out.println(left);

    }
}
