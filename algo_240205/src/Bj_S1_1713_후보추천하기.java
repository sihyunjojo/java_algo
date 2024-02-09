// 후보 추천하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 우선순위 큐 사용법
// 출력 양식 잘지키기 제발...
public class Bj_S1_1713_후보추천하기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int reco_n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> picture = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                // o1[0]이 같으면 o1[2]가 더 크면 우선순위가 높음
                if (o1[2] > o2[2]) {
                    return 1;
                } else if (o1[2] < o2[2]) {
                    return -1;
                } else {
                    // o1[0]과 o1[2]가 모두 같으면 같다고 판단
                    return 0;
                }
            }
//            if (o1[0] != o2[0]){
//                return o1[0] - o2[0];
//            }
//            if (o1[0] == o2[0]){
//                return o1[2] - o2[2];
//            }
//            return o1[0] - o2[0];
//            return o1[0] - o2[0];

//            if (o1[0] != o2[0]){
//                return o1[0] - o2[0];
//            }
//            return o1[2] - o2[2];
        });


        if (reco_n != 0){
            st = new StringTokenizer(br.readLine());
            loop:
            for (int i = 0; i < reco_n; i++){
                int tmp = Integer.parseInt(st.nextToken());

                if (picture.size() < n){
                    for (int[] ints : picture) {
                        if (ints[1] == tmp){
                            int count = ints[0] + 1;
                            int level = ints[2];
                            picture.remove(ints);
                            picture.add(new int[]{count,tmp,level});
//                        for (int[] inta : picture) {
//                            System.out.printf(Arrays.toString(inta));
//                        }
//                        System.out.println();
                            continue loop;
                        }
                    }
                    picture.add(new int[]{1,tmp,i});
                }
                else {
                    for (int[] ints : picture) {
                        if (ints[1] == tmp){
                            int count = ints[0] + 1;
                            int level = ints[2];
                            picture.remove(ints);
                            picture.add(new int[]{count,tmp,level});
//                        for (int[] inta : picture) {
//                            System.out.printf(Arrays.toString(inta));
//                        }
//                        System.out.println();
                            continue loop;
                        }
                    }
                    picture.poll();
                    picture.add(new int[]{1,tmp,i});
                }
//            for (int[] ints : picture) {
//                System.out.printf(Arrays.toString(ints));
//            }
//            System.out.println();
            }
        }

//
//        for (int[] ints : picture) {
//            System.out.printf(Arrays.toString(ints));
//        }
//        System.out.println();

        int tmp = 1001;
//        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        picture.comparator();
        int pi_size = picture.size();
        for(int i =0; i < pi_size; i++){
            temp.add(picture.poll()[1]);
        }
        temp.sort((o1, o2) -> o1-o2);
        for (Integer i : temp) {
            sb.append(i).append(" ");
        }

//        for (int i = 0; i < n; i++){
//            int[] ints = picture.poll();
////            System.out.println(Arrays.toString(ints));
//            if (tmp == ints[0]){
//                temp.add(ints[1]);
//            } else{
//                arr.add(temp);
//                temp = new ArrayList<>();
//                temp.add(ints[1]);
//            }
//            tmp = ints[0];
//        }
//        arr.add(temp);

//        System.out.println(arr);
//        for (int i = arr.size()-1; i >= 0; i--){
//            for (Integer integer : arr.get(i)) {
//                sb.append(integer).append(" ");
//            }
//        }

        System.out.println(sb);
    }
}