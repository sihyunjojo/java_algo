import java.io.*;
import java.util.*;

// 톱니바퀴
// 아.. 문제를 재대로 이해를 하고 구현을 하자.!!
public class Bj_G5_14891_톱니바퀴 {
    static int wheels[],result,move_dir[];
    public static void main(String[] args) throws IOException {
        // n개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new int[4];
        for (int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            wheels[i] = Integer.parseInt(st.nextToken(),2);
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());


        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int init_wheel_num = Integer.parseInt(st.nextToken()) - 1;
            int init_dir = Integer.parseInt(st.nextToken());

            move_dir = new int[4];
            move_dir[init_wheel_num] = init_dir;

            for (int j = init_wheel_num; j < 3; j++){
                move_dir[j+1] = choice_dir(j,j+1, move_dir[j]);
            }
            for (int j = init_wheel_num; j > 0; j--){
                move_dir[j-1] = choice_dir(j-1 , j , move_dir[j]);
            }
//            System.out.println("move_dir " + Arrays.toString(move_dir));

            for (int j = 0; j < 4; j++){
                gogo(j);
            }

//            change(init_wheel_num, init_dir);
//            printAllWheel();
//
//            int tmp_wheel = wheels[init_wheel_num];
//            int dir = init_dir;
//            for (int j = init_wheel_num; j < 3; j++){
//                System.out.println("j "+ j);
//                dir = go(j,j+1, dir, true);
//            }
//
//            wheels[init_wheel_num] = tmp_wheel;
//            dir = init_dir;
//            System.out.println();
//            System.out.println();
//            printAllWheel();
//
//            for (int j = init_wheel_num; j > 0; j--){
//                System.out.println("j " +j);
//                dir = go(j-1, j, dir,false);
//
//            }
        }

        result = 0;
        cal_score();
        System.out.println(result);

    }
    // dir는 영향을 주는 wheel이 영향을 받는 wheel을 기준으로 어디 있는지 확인함.
    private static void gogo(int wheel_n) {
        change(wheel_n,move_dir[wheel_n]);
    }

    private static int go(int wheel1, int wheel2, int init_dir, boolean what_change){
        int change_dir = choice_dir(wheel1,wheel2,init_dir);

        if (what_change) change(wheel2,change_dir);
        else change(wheel1,change_dir);

        printAllWheel();
        return change_dir;
    }

    private static int choice_dir(int wheel1, int wheel2, int init_dir){
        if (init_dir == 0){
            return 0;
        }
        if (((wheels[wheel1] >> 5) & 1) == ((wheels[wheel2] >> 1) & 1)) {
            return 0;
        }
        if (init_dir == 1) {
            return -1;
        } return 1;

    }

    // dir 는 돌아가는 방향
    // dir = 1 시계 방향
    private static void change(int wheel_num, int dir){
        if (dir == 1){
            int tmp = wheels[wheel_num] % 2;
            wheels[wheel_num] = wheels[wheel_num] >> 1;
            wheels[wheel_num] += (128 * tmp);
        }
        if (dir == -1){
            int tmp = wheels[wheel_num] / 128;
            wheels[wheel_num] = wheels[wheel_num] << 1;
            wheels[wheel_num] %= 256;
            wheels[wheel_num] += tmp;
        }
    }

    private static void cal_score(){
        for(int i = 0; i < 4; i++){
            result += (((wheels[i] >> 7) & 1) * (int) Math.pow(2,i));
        }
    }
    public static void printbinary(int n){
        System.out.println(Integer.toBinaryString(wheels[n]));
    }
    public static void toBinaryString8(int num) {
        String binaryString = Integer.toBinaryString(wheels[num]);
        int paddingLength = 8 - binaryString.length();
        StringBuilder sb = new StringBuilder(binaryString);
        for (int i = 0; i < paddingLength; i++) {
            sb.insert(0, '0');
        }
        System.out.println(sb);
    }
    public static void printAllWheel(){
        System.out.println();
        for(int i = 0; i < 4; i++){
            toBinaryString8(i);
        }
        System.out.println();
    }
}