import java.io.*;
import java.util.*;

// 탑
public class Bj_G5_14891_톱니바퀴 {
    static int[] wheels;
    public static void main(String[] args) throws IOException {
        // n개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new int[4];
        for (int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            wheels[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int[][] commend = new int[k][2];
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            commend[i][0] = Integer.parseInt(st.nextToken());
            commend[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = 0;

        System.out.println(wheels[0]);
        change(wheels[0],1);
        System.out.println(wheels[0]);
        change(wheels[0],2);
        System.out.println(wheels[0]);

    }
    // dir는 영향을 주는 wheel이 영향을 받는 wheel을 기준으로 어디 있는지 확인함.
    // dir = 1 오른쪽
    private static void go(int wheel1, int wheel2, int dir){
        if (dir == 1){
//            wheels[wheel1] <<
        }
    }
    // dir 는 돌아가는 방향
    // dir = 1 시계 방향
    private static void change(int wheel_num,int dir){
        if (dir == 1){
            int tmp = wheels[wheel_num] / 128;
            wheels[wheel_num] = wheels[wheel_num] << 1;
            wheels[wheel_num] += tmp;
        }
        if (dir == 2){
            int tmp = wheels[wheel_num] % 2;
            wheels[wheel_num] = wheel_num >> 1;
            wheels[wheel_num] += (128 * tmp);
        }
    }
}