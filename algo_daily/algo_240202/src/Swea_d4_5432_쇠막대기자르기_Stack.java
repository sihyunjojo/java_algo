import java.io.*;
import java.util.Stack;

// 내 코드아님.
public class Swea_d4_5432_쇠막대기자르기_Stack {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t < testCase + 1; t++) {
            char[] arr = br.readLine().toCharArray();

            int ans = 0;

            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {

                if(arr[i] == '(') {
                    stack.push(arr[i]);
                    flag = false;
                } else {

                    if(flag) {
                        if(!stack.isEmpty()) {
                            stack.pop();
                            ans++;
                        }
                        continue;
                    }

                    if(!stack.isEmpty()) {
                        stack.pop();
                        ans += stack.size();
                    }

                    flag = true;

                }


            }

            bw.write(String.format("#%d %d\n", t, ans));

        }

        bw.flush();

    }
}