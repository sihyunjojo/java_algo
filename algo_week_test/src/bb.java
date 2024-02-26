package abc;

import java.awt.List;
import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.stream.events.EndDocument;

// 회의실 배정.
// 즉 3월 1일부터 11월 30일까지 매일 한
// 가지 이상 프로젝트에 참여하고 있을 수 있도록 프로젝트를 선택할 때, 선택한 프로젝트들의
// 최소 개수를 출력하는 프로그램을 작성하시오.
public class Algo2_구미_4반_조시현 {
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

//			int pro_len;
//			if (end < 335) pro_len= end - 59;
//			else pro_len = 335 - start;
//
//			this.pro_len =
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
        // 60 , 335
//		System.out.println(new Pro(3, 1, 12, 1));

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

//		for (Pro pro : pros) {
//			System.out.println(pro);
//		}

        int res = 1;
        Pro temp_pro = pros.get(0);
        if (pros.size() == 1 && temp_pro.end < 60) {
            res = 0;
        }
        if (pros.size() == 1 && temp_pro.start >= 60 && temp_pro.end <= 335) {
            res = 0;
        }
        for (int i = 1; i < pros.size(); i++) {
            Pro pro = pros.get(i);
//			System.out.println("temp" + temp_pro + " pro " + pro);

            // 실패
            if(temp_pro.end < pro.start) {
                res = 0;
                break;
            }
            if (temp_pro.end >= pro.start) {
                if (pro.start <= 60) {
                    if (temp_pro.end - 59 < pro.end - 59) {
                        temp_pro = pro;
                        continue;
//						res++;
                    }
                }
                else {
                    if (temp_pro.end - 59 < pro.end - 59) {
                        temp_pro = pro;
                        res++;
                    }
                }
//				temp_pro = pro;
//				res++;

            }
//			System.out.println(res);
        }

        System.out.println(res);

    }

}
