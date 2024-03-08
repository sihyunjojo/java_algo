package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Bj_S3_17952_과제는끝나지않아 {
    static class Work{
        int index;
        int score;
        int time;
        public Work(int index, int score, int time) {
            super();
            this.index = index;
            this.score = score;
            this.time = time;
        }
        @Override
        public String toString() {
            return "Work [index=" + index + ", score=" + score + ", time=" + time + "]";
        }



    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(br.readLine());
        int index = 0;

        // 인덱스 2개로도 구현 가능할듯?

        int res = 0;
        ArrayDeque<Work> works = new ArrayDeque<>();
        Work go_work;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            char check = stringTokenizer.nextToken().charAt(0);
            if (check == '1'){
                int score = Integer.parseInt(stringTokenizer.nextToken());
                int time = Integer.parseInt(stringTokenizer.nextToken());
                go_work = new Work(index++,score,time);
            }
            else {
                // 해야할 일 없으면 패스
                if (works.isEmpty()) continue;
                // 하나라도 있으면 맨 마지막꺼 꺼내서 하기.
                go_work = works.pollLast();
            }

            go_work.time--;
            // 그냥 1초만에 할 수 있으면 바로 해결
            if (go_work.time == 0) {
                res += go_work.score;
                continue;
            }

            works.add(go_work);
        }

        System.out.println(res);
    }
}
