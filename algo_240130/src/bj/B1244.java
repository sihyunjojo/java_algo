package bj.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    static int[] arr;
    static int[][] p_option;
    public static void main(String[] args) throws IOException {

        // 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다
        // 자신의 성별과 받은 수에 따라
        // 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다
        // 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로
        // 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
        // 그 구간에 속한 스위치의 상태를 모두 바꾼다.
        // 스위치들의 마지막 상태를 출력하는 프로그램을 작성하시오.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p_count =  Integer.parseInt(st.nextToken());

        int[][] p_option = new int[p_count][2];

        for (int i=0; i< p_count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1){
                int temp = b;
                // 이 방식보다 for 문을 통해서 i + b처럼 해주는게 더 가시적으로 좋은 코드이다.
                while (n >= b){
                    arr[b-1] = (arr[b-1] + 1) % 2;
                    b += temp;
                }
            }
            int c = b;
            int d = b;
            if (a == 2){
                arr[b-1] = (arr[c-1] + 1) % 2;
                while (true){
                    c = c - 1;
                    d = d + 1;
                    if (c > 0 && d <= n){
                        if (arr[c-1] == arr[d-1]){
                            arr[c-1] = (arr[c-1] + 1) % 2;
                            arr[d-1] = (arr[d-1] + 1) % 2;
                        }else break;
                    }else break;
                }
            }
        }

        for (int i = 0; i < n; i++){
            System.out.printf("%d ",arr[i]);
            if (i % 20 == 19){
                System.out.println();
            }
        }
    }
}
