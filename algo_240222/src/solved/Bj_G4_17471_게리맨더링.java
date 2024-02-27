package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어디서든지 true를 해주면 false를 해줘야한다.
// 배열 불린타입보다 리스트 인티저가 배로 좋은듯
// 코드를 반전 시켜준 다음에 반드시 if문 위치를 잘 보고 다시 되돌려줘야한다.
// 5시간 걸림.
public class Bj_G4_17471_게리맨더링 {
    static boolean[] choice_place;
    static int all_people_count,n,res;
    static int[] peoples;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        peoples = new int[n+1];
        all_people_count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            peoples[i] = Integer.parseInt(st.nextToken());
            all_people_count += peoples[i];
        }

        arr = new ArrayList[n+1];
        for (int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        // 1번 구역 == 0번 인덱스
        for (int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            int road_num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < road_num; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i].add(num);
            }
        }
//        System.out.println(Arrays.toString(arr));
        choice_place = new boolean[n+1];


        res = Integer.MAX_VALUE;
        c(1);

        if (res == Integer.MAX_VALUE) res = -1;

        System.out.println(res);
    }

    static void c(int count){
        if (count == n+1){
//            System.out.println(Arrays.toString(choice_place));
            if (isCheckCon(choice_place)){
//                System.out.println(Arrays.toString(choice_place));
                boolean[] temp = new boolean[n+1];
                for (int i = 1; i < n+1; i++){
                    if (choice_place[i]){
                        temp[i] = false;
                    } else temp[i] = true;
                    if (temp[i]){
                        choice_place[i] = true;
                    } else  choice_place[i] = false;
                }
//                System.out.println("temp = " + Arrays.toString(temp));
                if (isCheckCon(temp)){
//                    System.out.println("ok");
                    int dif = cal_dif(choice_place);
//                    print__a(choice_place);
                    if (res > dif) {
                        res = dif;
//                        System.out.println("aaaa " + Arrays.toString(choice_place));
                    }
                }
                for (int i = 1; i < n+1; i++){
                    if (choice_place[i]){
                        choice_place[i] = false;
                    } else  choice_place[i] = true;
                }
            }
            return;
        }
        choice_place[count] = true;
        c(count+1);
        choice_place[count] = false;
        c(count+1);
    }

    private static boolean isCheckCon(boolean[] choice_place) {
        int start = 0;
        boolean[] point_check = new boolean[n+1];

        for (int i = 1; i <= n; i++){
            if (choice_place[i]){
                start = i;
                break;
            }
        }
//        System.out.println("start" + start);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        point_check[start] = true;

//        print__a(point_check);
        // 처음에서 연결된 간선 없으면 false;
//        if (arr[start].isEmpty()) return false;
//        print__a(point_check);
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < arr[now].size(); i++){
                int next = arr[now].get(i);
                if(point_check[next]) continue;
                if(!choice_place[next]) continue; // 이 코드가 그 5
//                1 3 2 4 5
//                1 3
//                3 5 4 3
//                2 1 2
//                1 2
//                1 2
                // 이거 해결해줌
                q.add(next);
                point_check[next] = true;
//                print__a(point_check);

            }
        }
//        System.out.println(Arrays.toString(point_check));


        if (is_check(point_check)) {
            return true;
        }
        return false;
    }

    private static boolean is_check(boolean[] point_check){
        int place_cnt = 0;
        for (int i = 1; i < n+1; i++){
            if (choice_place[i]){
                place_cnt += 1;
                if (!point_check[i]){
                    return false;
                }
            }
        }
        if (place_cnt == 0) return false;
        return true;
    }

    private static int cal_dif(boolean[] choice_place){
        int this_cnt = 0;
        for (int i = 0; i < n; i++){
            if (choice_place[i+1]){
                this_cnt += peoples[i+1];
//                System.out.println(peoples[i]);
            }
        }
        return Math.abs(all_people_count - this_cnt - this_cnt);
    }

    static void print__a(boolean[] a){
        if (Arrays.equals(choice_place, new boolean[]{false, true, true, false})){
            System.out.println(" aaaaaaaaa " + Arrays.toString(a));
            System.out.println("place" + Arrays.toString(choice_place));

        }
        if (Arrays.equals(choice_place, new boolean[]{false, false, false, true})){
            System.out.println(" aaaaaaaaa " + Arrays.toString(a));
            System.out.println("place" + Arrays.toString(choice_place));
        }
    }
}

//6
//2 2 2 2 2 2
//1 3
//1 4
//1 1
//1 2
//1 6
//1 5

//3
//1 2 1
//1 2
//2 1 3
//1 2

//5
//5 2 3 4 1
//1 2
//4 1 3 5 4
//1 2
//1 2
//1 2

//3
//1 10 3
//1 2
//1 3
//1 1