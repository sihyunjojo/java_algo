import java.io.*;
import java.util.*;


public class Solution {
    static class Micro{
        int x;
        int y;
        int cnt;
        int dir;
        int index;

        Micro(int i,int x, int y, int cnt, int dir){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.index = i;
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
            if (micro.cnt == 0) { // 없으면 보드와 리스트에서 없애줌.
                micros.remove(micro);
                i--;
            }
        }

        // mix 해결.
        micros.sort((m1, m2) -> {
            if (m1.x == m2.x) {
                return m1.y - m2.y;
            }
            return m1.x - m2.x;
        });

        for (int i = 0; i < micros.size(); i++){
            Micro micro1 = micros.get(i);
            List<Micro> temp_micros = new ArrayList<>(List.of(micro1));

            for (int j = i+1; j < micros.size(); j++){
                Micro micro2 = micros.get(j);
                if (micro1.equals(micro2)){
                    temp_micros.add(micro2);
                    micros.remove(micro2);
                    j--;
                    i--;
                } else {
                    break;
                }
            }

            if (temp_micros.size() > 1){
                Micro mixMicro = mix(temp_micros);
                micros.add(mixMicro);
            }
        }
    }

    static Micro mix(List<Micro> micros){
        micros.sort((o1, o2) -> -(o1.cnt - o2.cnt));
        Micro micro = micros.get(0);
        for (int i =1; i < micros.size(); i++){
            micro.cnt += micros.get(i).cnt;
        }
        return micro;
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
                    m.y = 1;
                    break;
                case 2:
                    m.dir = 1;
                    m.y = n-1;
                    break;
                case 3:
                    m.dir = 4;
                    m.x = 1;
                    break;
                case 4:
                    m.dir = 3;
                    m.x = n-1;
                    break;
            }
        }
    }
    static void mix(){

    }
}