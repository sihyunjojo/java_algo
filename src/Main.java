import javax.swing.text.html.ListView;
import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 너무너무너무너무너무 어려움
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++){
            q.add(i+1);
        }

        System.out.println(q);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }


    }
}

