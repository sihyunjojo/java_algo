package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 계란으로 계란 치기
// ans 값 넣어서 함수도 만들어보기
public class Bj_G5_167987_계란으로계란치기 {
    static int n,arr[][],res;
    public static void main(String[] args) throws IOException {
        // 각 계란에는 내구도와 무게가 정해져있다.
        // 내구도가 0 이하가 되는 순간 계란은 깨지
        // 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다.

        // 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
        // 3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
        // 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        cal(0);

        System.out.println(res);
    }
    private static void cal(int egg1_loc){
        if (egg1_loc == n){
            int ans = 0;
            for (int i= 0; i<n;i++){
                if (arr[i][0] <= 0) ans++;
            }
            if (res < ans) res = ans;

            for (int[] ints : arr) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            return;
        }

        if (arr[egg1_loc][0] <= 0) {
            cal(egg1_loc+1);
            return;
        }

        int count = 0;
        for (int j = 0; j < n; j++){
            if (j==egg1_loc) continue;
            if (arr[j][0] <= 0){
                count += 1;
            }
        }
        if (count == n-1) {
            cal(egg1_loc+1);
            return;
        }

        for (int i = 0; i < n; i++){
            // System.out.println("i "+ i);
            int flag = 0;
            if (i == egg1_loc) continue;
            if (arr[i][0] <= 0) continue;

            // System.out.println(egg1_loc+ " " +i);
            arr[egg1_loc][0] -= arr[i][1];
            arr[i][0] -= arr[egg1_loc][1];
            cal(egg1_loc+1);
            arr[egg1_loc][0] += arr[i][1];
            arr[i][0] += arr[egg1_loc][1];

        }
    }
}




