package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회의실 배정.
// 즉 3월 1일부터 11월 30일까지 매일 한
// 가지 이상 프로젝트에 참여하고 있을 수 있도록 프로젝트를 선택할 때, 선택한 프로젝트들의
// 최소 개수를 출력하는 프로그램을 작성하시오.
public class Bj_G3_2457_공주님의정원 {
    static int[] month_day = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};

    static class Pro implements Comparable<Pro>{
        int start;
        int end;

        public Pro(int m1, int d1,int m2,int d2) {
            super();
            int start = 0;
            // 일을 하는 날짜
            int end = 0;

            for (int i = 0; i < m1; i++) {
                start += month_day[i];
            }
            start += d1;
            for (int i = 0; i < m2; i++) {
                end += month_day[i];
            }
            end += d2;

            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "pro [start=" + start + ", end=" + end + "]";
        }


        @Override
        public int compareTo(Pro o) {
            if (this.start == o.start){
                return -(this.end - o.end);
            }
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(br.readLine());

        List<Pro> pros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(stringTokenizer.nextToken());
            int d1 = Integer.parseInt(stringTokenizer.nextToken());
            int m2 = Integer.parseInt(stringTokenizer.nextToken());
            int d2 = Integer.parseInt(stringTokenizer.nextToken());

            pros.add(new Pro(m1,d1,m2,d2));
        }
        Collections.sort(pros);

        int endDay = 335;
        int start = 60;
        int count = 0;
        int max_end = 0;
        int index = 0;


        while(start < endDay) {
            boolean isFinded = false;	// 새 꽃 찾은지 여부 확인

            // 기준 시작점보다 더 커지면 나옴.
            for(int i = index; i < n; i++) {
                if(pros.get(i).start > start) {	// 종료일보다 시작일이 이후면 의미없음. 종료일에는 시작해야 이어지기 때문에
                    break;
                }

                if(max_end < pros.get(i).end) {
                    isFinded = true; // 이게 좀 그거 인듯.
                    max_end = pros.get(i).end;
                    index = i + 1; // 이걸로 그렇게 굴리는건 좀 다른 쪽에서도 자주 쓰일듯하다.
                }
//                System.out.println(pros.get(i));
            }

            // 하나라도 찾았으면 그걸로 start 바꿔주고 1 증가시켜주고
            if(isFinded) {
                start = max_end;
                count++;
            }
            else {
                break;
            }
        }

        if(max_end < endDay) {
            System.out.println(0);
        }
        else {
            System.out.println(count);
        }

        System.out.println(count);
    }
}
