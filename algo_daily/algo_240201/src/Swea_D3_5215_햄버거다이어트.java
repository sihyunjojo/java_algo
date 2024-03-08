import java.io.*;
import java.util.StringTokenizer;

public class Swea_D3_5215_햄버거다이어트 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result, foods[][], L, n;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputFile/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            result = 0;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            foods = new int[n][2];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                foods[i][0] = Integer.parseInt(st.nextToken()); //점수
                foods[i][1] = Integer.parseInt(st.nextToken()); //칼로리
            }

            cook(0,0,0);

            bw.write("#"+tc+" "+result+ "\n");
        }
        bw.flush();
    }
    private static void cook(int count,int cals, int flavors){
        if (count == n) {
            if (result < flavors) result = flavors;
            return;
        }
        if (cals <= L) cook(count+1, cals, flavors);
        if (cals + foods[count][1] <= L) cook(count+1, cals + foods[count][1],flavors+ foods[count][0]);
    }
}
