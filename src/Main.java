import javax.swing.text.html.ListView;
import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];
        list[0] = arr[0];

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (list[res] < arr[i]) {
                list[++res] = arr[i];
            }
        }

        System.out.println(res+1);
        for (int i = 0; i <= res; i++) {
            System.out.print(list[i] + " ");
        }


    }
}