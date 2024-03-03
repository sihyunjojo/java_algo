package refactor;

import java.io.FileInputStream;
import java.io.*;
import java.util.*;

// 삭제는 무조건 다 움직여주고 하는게 좋다.
// 왜냐면 꼬일 수 도있다.
// 그리고 remove 를 객체로 하면 remove를 equals와 같은것을 다해준다???
// 그러니까 그럼 인덱스를 통해서 지워줘야 정확히 지워준다ㅣ.
// 그래서 민종이는 직접 보통 삭제를 구현한다고 한다.


public class Swea_2382_미생물격리 {
    static class Micro{
        int x;
        int y;
        int cnt;
        int dir;
        List<Integer> index = new ArrayList<>();
        List<Integer> aa = new ArrayList<>();

        Micro(int i,int x, int y, int cnt, int dir){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.index.add(i);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Micro micro = (Micro) o;
            return x == micro.x && y == micro.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static StringBuilder sb = new StringBuilder();
    static List<Micro> micros;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input2382.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            micros = new ArrayList<>();

            for (int i = 1; i <= k; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                micros.add(new Micro(i,x,y,cnt,dir));
            }

            for (Micro micro : micros) {
                System.out.println(micro);
            }
            System.out.println();

            // 시간당 움직임.
            for (int i = 0; i < m; i++){
                go();
            }

            int res = 0;

            for (int i = 0; i < micros.size(); i++){
                res += micros.get(i).cnt;
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    static void go(){
        // 전부 움직이고 약 닿으면 줄이고 방향 바꾸고
        for (int i = 0; i < micros.size(); i++){
            Micro micro = micros.get(i);
            move(micro);
            if (micro.cnt == 0) { // 없으면 보드와 리스트에서 없애줌. // 이걸 꼭 나중에 해줘야함...
                micros.remove(micro);
                i--;
            }
        }
        // mix 해결.
        micros.sort((m1, m2) -> {
            if (m1.x == m2.x && m1.y == m2.y){
                return -(m1.cnt - m2.cnt);
            }
            if (m1.x == m2.x) {
                return m1.y - m2.y;
            }
            return m1.x - m2.x;
        });


        for (int i = 0; i < micros.size(); i++){
            Micro micro1 = micros.get(i);

            for (int j = i+1; j < micros.size(); j++){
                Micro micro2 = micros.get(j);
                if (micro1.equals(micro2)){
                    micro1.cnt += micro2.cnt;
                    micros.remove(j);
                    i--;
                } else {
                    break;
                }
            }
        }
    }
    static void move(Micro m){
        switch (m.dir){
            case 1:
                m.y -= 1;
                break;
            case 2:
                m.y += 1;
                break;
            case 3:
                m.x -= 1;
                break;
            case 4:
                m.x += 1;
                break;
        }
        sick(m); // 움직였는데 약이면
    }
    static void sick(Micro m){
        if (m.x == 0 || m.y == 0 || m.y == n-1 || m.x == n-1){ // 약에 닿으면
            m.cnt /= 2;
            switch (m.dir){
                case 1:
                    m.dir = 2;
                    break;
                case 2:
                    m.dir = 1;
                    break;
                case 3:
                    m.dir = 4;
                    break;
                case 4:
                    m.dir = 3;
                    break;
            }
        }
//        if (m.cnt == 0) { // 없으면 보드와 리스트에서 없애줌.
//            micros.remove(m);
//        }
    }
}
// 오답
//#1 145
//#2 5507
//#3 9709
//#4 2669
//#5 3684
//#6 774
//#7 4317
//#8 8580
//#9 1374
//#10 5229
//
//// 정답
//#1 145
//#2 5507
//#3 9709
//#4 2669
//#5 3684
//#6 774
//#7 4797
//#8 8786
//#9 1374
//#10 5040

// 10번 입력 값
//10 24 12
//6 5 887 2
//2 3 428 1
//2 1 540 2
//8 1 356 4
//1 7 485 4
//5 1 357 3
//7 6 271 2
//6 2 22 1
//6 1 41 2
//8 2 565 2
//8 5 855 1
//6 3 734 1