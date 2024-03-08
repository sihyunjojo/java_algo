import java.io.*;
import java.util.*;
public class Bj_S3_10972_다음순열_Fast {
    static int n;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(t[i]);
        }
        int i = n - 1;
        while (i > 0 && arr[i] < arr[i - 1]) {
            i--;
        }
        if (i <= 0) {
            System.out.println(-1);
            return;
        }
        int j = n - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = n - 1;

        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }


        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}