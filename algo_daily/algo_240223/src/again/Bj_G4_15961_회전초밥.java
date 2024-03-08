package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_G4_15961_회전초밥 {
    static int n, d, k, c, res;
    static int[] arr, eat_susi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가지수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        res = 0;
        arr = new int[n+k-1];
        eat_susi = new int[d+1];

        // 인덱스 1부터 판단하므로 0일떄 1개 무조건 있음.
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 1 <= arr[i] <= d
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n+k-1; i++){
            arr[i] = arr[i-n];
        }

        int i = 0;
        // arr => n + k-1
        //
        while (i < arr.length) {
            // 기존에 하나도 없던거 넣으면 +1;
            //System.out.println(arr[i]);
            if (eat_susi[arr[i]] == 0) {
                ans += 1;
            }
            // 넣어주고
            eat_susi[arr[i]] += 1;
            //
            if (i >= k-1) {
                if (eat_susi[c] == 0)
                    ans++;

                if (res < ans) res = ans;

                //System.out.println(Arrays.toString(eat_susi));

                if(eat_susi[arr[i-k +1]] == 1){
                    ans--;
                }
                if(eat_susi[c] == 0)
                    ans--;
                eat_susi[arr[i-k+1]]--;
            }

            i++;

        }

        System.out.println(res);
    }
}