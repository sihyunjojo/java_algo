import java.io.*;
import java.util.StringTokenizer;

public class Swea_d4_1218_괄호짝짓기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("./inputFile/input5.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++){
            int result = 0;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            char[] line = st.nextToken().toCharArray();
            int[] arr = new int[4];
            for (char c: line){
                if (c == '('){
                    arr[0] += 1;
                }
                if (c == '['){
                    arr[1] += 1;
                }
                if (c == '{'){
                    arr[2] += 1;
                }
                if (c == '<'){
                    arr[3] += 1;
                }
                if (c == ')'){
                    arr[0] -= 1;
                }
                if (c == ']'){
                    arr[1] -= 1;
                }
                if (c == '}'){
                    arr[2] -= 1;
                }
                if (c == '>'){
                    arr[3] -= 1;
                }
            }
            boolean flag = true;
            for (int i = 0; i < 4; i++){
                if (arr[i] != 0){
                    flag = false;
                }
            }

            if (flag) result = 1;

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
