import java.io.*;
import java.util.*;

// 배열 채우는 것
public class Bj_S5_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] white = new int[100][100];
        int[][] black = new int[10][10];

        for (int[] value : black) {
            Arrays.fill(value, 1);
        }

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for (int j = w; j < w + 10; j++){
                for (int k = h; k < h + 10; k++){
                    if (white[j][k] != 1){
                        white[j][k] = 1;
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}