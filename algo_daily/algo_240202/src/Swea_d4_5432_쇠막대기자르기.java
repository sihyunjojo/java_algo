import java.io.*;
import java.util.*;

// 구현
public class Swea_d4_5432_쇠막대기자르기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/sample_input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++){
            String line = br.readLine();
            char tmp = ' ';
            int result  =0, stick_n = 0, razer_n = 0;
            for (int i = 0; i < line.length(); i++){
                if (line.charAt(i) == ')'){
                    if (tmp == '(') {
                        --stick_n;
                        razer_n++;
                        result += stick_n;
                    }
                    else {
                        stick_n--;
                        result++;
                    }
                } else {
                    stick_n++;
                }
                tmp = line.charAt(i);
                System.out.println(i+" "+result);
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
