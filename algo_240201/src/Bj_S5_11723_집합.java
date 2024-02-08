import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모두 0으로 하면 빈 것처럼 생각 가능.
public class Bj_S5_11723_집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[21];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = 0;
            String commend = st.nextToken();
            if (st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
            switch (commend){
                case "all": Arrays.fill(arr, 1);
                    break;
                case "empty": Arrays.fill(arr, 0);
                    break;
                case "add": arr[num] = 1;
                    break;
                case "remove": arr[num] = 0;
                    break;
                case "check": sb.append(arr[num]).append("\n");
                    break;
                case "toggle":
                    // 이프문 보다 빠름.
                    arr[num] = arr[num] == 1 ? 0 : 1;
                    break;
            }
        }
        System.out.println(sb);
    }
}
