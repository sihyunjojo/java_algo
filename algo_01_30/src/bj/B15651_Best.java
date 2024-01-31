package bj;

import java.util.Scanner;

// 인자로 String을 받아와서 반복문 없이 바로바로 넣어줘서 출력해줌.
public class B15651_Best {

    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sb = new StringBuilder();
        solve("", 0);

        System.out.println(sb);
        sc.close();
    }

    static void solve(String s, int am) {

        if (am == m) {
            sb.append(s + "\n");
        } else {
            for (int i = 1; i <= n; i++) {
                solve(s + i + " ", am + 1);
            }
        }
    }

}

