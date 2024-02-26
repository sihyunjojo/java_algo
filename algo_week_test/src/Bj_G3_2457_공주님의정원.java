import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 회의실 배정.
// 즉 3월 1일부터 11월 30일까지 매일 한
// 가지 이상 프로젝트에 참여하고 있을 수 있도록 프로젝트를 선택할 때, 선택한 프로젝트들의
// 최소 개수를 출력하는 프로그램을 작성하시오.
public class Bj_G3_2457_공주님의정원 {
    static int[] month_day = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static class Pro{
        int start;
        int end;
        int pro_len;

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
            this.end = end-1;

        }

        @Override
        public String toString() {
            return "pro [start=" + start + ", end=" + end + "]";
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Pro> pros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(stringTokenizer.nextToken());
            int d1 = Integer.parseInt(stringTokenizer.nextToken());
            int m2 = Integer.parseInt(stringTokenizer.nextToken());
            int d2 = Integer.parseInt(stringTokenizer.nextToken());

            pros.add(new Pro(m1,d1,m2,d2));
        }
        // 60 , 333
        System.out.println(new Pro(3,1,11,30));

        pros.sort((o1,o2) -> {
            if (o1.start == o2.start) {
                return -(o1.end - o2.end);
            }
            return o1.start - o2.start;
        });


        for (int i = 0; i < n; i++) {
            Pro pro = pros.get(i);
            if (pro.end < 60) {
                pros.remove(i);
                i--;
            }
            if (pro.start > 335) {
                pros.remove(i);
                i--;
            }
        }

        int res = 1;

        Pro temp_pro = pros.get(0);

        for (int i = 1; i < pros.size(); i++) {
            Pro pro = pros.get(i);
			System.out.println("temp" + temp_pro + " pro " + pro);

            // 실패
            if(temp_pro.end < pro.start) {
                res = 0;
                break;
            }


            // 이 로직은 괜찮은거 같은데..
            if (pro.start <= 60) {
                if (temp_pro.end - 59 < pro.end - 59) {
                    temp_pro = pro;
                }
            }

            else {
                if (temp_pro.end - 59 < pro.end - 59) {
                    temp_pro = pro;
                    res++;
                }
            }

            if (pros.size() == 1) {
                res = 0;
            }
            if (pros.size() == 1 && temp_pro.start <= 60 && temp_pro.end > 333) {
                res = 1;
            }

            if (pros.isEmpty()){
                res = 0;
            }

        }
        System.out.println(res);
    }
}
