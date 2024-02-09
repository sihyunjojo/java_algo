import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Swea_D4_1233_사칙연산유효성검사 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1233.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 10; i++){
            sb.append("#").append(i).append(" ");
            int n = Integer.parseInt(br.readLine());
            List<String> pi = new ArrayList<>(Arrays.asList("+","-","*","/"));
            boolean flag = false;

            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                if (flag) continue;
                st.nextToken();
                if (st.countTokens() == 3){
                    String s = st.nextToken();
                    if (!pi.contains(s)) {
                        System.out.println(s);
                        sb.append(0).append("\n");
                        flag = true;
                    }
                }
            }
            if (!flag) sb.append(1).append("\n");
        }
        System.out.println(sb);
    }
}
