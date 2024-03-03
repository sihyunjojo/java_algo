import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// dp 로 풀어보기?
public class Swea_2383_점심식사시간 {
    static StringBuilder sb = new StringBuilder();
    static int[][] board, stairs;
    static int[] temp_arr;
    static ArrayList<int[]> persons;
    static int n, res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("InputFile/input2383.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            stairs = new int[2][2];
            int stair_index = 0;
            persons = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] > 1) {
                        stairs[stair_index++] = new int[]{i, j};
                    }
                    if (board[i][j] == 1) persons.add(new int[]{i, j});
                }
            }

            temp_arr = new int[persons.size()];

            res = Integer.MAX_VALUE;

            go();
            sb.append(res+1).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        powerset(0);
    }

    static void powerset(int count) {
        if (count == persons.size()) {
            int stair0 = count_time(0);
            int stair1 = count_time(1);

            int max = Math.max(stair1, stair0);
            if (max < res) res = max;
            return;
        }
        temp_arr[count] = 0;
        powerset(count + 1);
        temp_arr[count] = 1;
        powerset(count + 1);
    }

    static int count_time(int stair) {
//        System.out.println("stair = " + stair);
//        System.out.println("temp = " + Arrays.toString(temp_arr));

        int max_dis = 0;
        ArrayList<Integer> person_stair_dis = new ArrayList<>();

        for (int i = 0; i < temp_arr.length; i++) {
            if (temp_arr[i] == stair) {
                int dis = cal_dis(persons.get(i), stairs[stair]);
                person_stair_dis.add(dis);
                if (max_dis < dis) max_dis = dis;
            }
        }

        Collections.sort(person_stair_dis);

        int stair_time = board[stairs[stair][0]][stairs[stair][1]];
        int time = 0;
        int wait_people = 0;
        int[] stair_people = new int[3];

        while (true) {
            time++;
            // 기다리는 사람 있으면 계단에 사람들 보내줌.
            // 앞에서 부터
            for (int i = 0; i < 3; i++) {
                if (stair_people[i] == 0 && wait_people > 0) {
                    stair_people[i] = stair_time - 1;
                    wait_people--;
                } else if (stair_people[i] > 0) {
                    stair_people[i]--;
                }
            }

            // 그 시간이 되면 다들 기다리는 사람으로 해줌.
            for (int i = 0; i < person_stair_dis.size(); i++) {
                Integer person_dis = person_stair_dis.get(i);
                if (person_dis == time) {
                    wait_people++;
                }
            }

            System.out.println("time = " + time);
            System.out.println("wait = " + wait_people);
            System.out.println("stair_people= " + Arrays.toString(stair_people));


            int finish_flag = 0;
            if (time > max_dis) {
                for (int i = 0; i < 3; i++) {
                    if (stair_people[i] == 0) {
                        finish_flag++;
                    }
                }
            }
            if (finish_flag == 3) break;
        }
        System.out.println(time);
        return time;
    }

    static int cal_dis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}