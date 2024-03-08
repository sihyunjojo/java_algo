import java.util.*;

// 내 코드보다 4배나 빠름.
public class Bj_Silver3_15649_n과m1_Best {
    static int n, m;
    static boolean[] vst;
    static StringBuffer sb = new StringBuffer();

    static void BT(String str, int cnt) {
        if (cnt == m) {
            sb.append(str.trim() + "\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vst[i]) {
                vst[i] = true;
                BT(str + i + " ", cnt + 1);
                vst[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        vst = new boolean[n + 1];
        BT("", 0);
        System.out.print(sb);
    }
}
