package again;

import java.io.*;
import java.util.*;


// charge라는 객체를 선언해서 관리..?
// 거리를 기준으로 안에 둘다 있으면,
// 객체를 만들어서 해주는게 추후에 유지보수나 코드를 고칠때 편할거 같다.
// 정점이 움직이는 문제를 풀 때, 모든 정점이 겪을 수 있는 경우의 수를 모두 생각해보자.
// 정점 2개가 움직이면 더 많이 갈리겠지???
//같은 위치           다른 위치
//                같은 chage 다른 charge
//            1개 겹침   2개겹침

// 결국 for문으로 max값을 구해서 그걸 더해줘야함.
public class Swea_5644_무선충전 {
    static class Charger {
        int x;
        int y;
        int c;
        int p;
        int i;
        public Charger(int i, int x, int y, int c, int p) {
            super();
            this.i = i;
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        @Override
        public String toString() {
            return i + "/" + p;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static Charger[] chargers;
    static int m,a,res;
    static int[][] delta = new int[][] {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            res = 0;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            int[][] user_move = new int[2][m];
            board = new int[10][10];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    user_move[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            chargers = new Charger[a];
            for (int i = 0; i < a; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers[i] = new Charger(i,x-1,y-1,c,p);
            }
            // 높은 순으로 정렬
            Arrays.sort(chargers, Comparator.comparingInt(c -> -(c.p)));


            int[] user1_loc = new int[] {0,0};
            int[] user2_loc = new int[] {9,9};
            ArrayList<Charger> temp1;
            ArrayList<Charger> temp2;
            temp1 = count_charge_place(user1_loc[0],user1_loc[1]);
            temp2 = count_charge_place(user2_loc[0],user2_loc[1]);
            calc(temp1,temp2);

            for (int i = 0; i < m; i++){
                user1_loc[0] += delta[user_move[0][i]][0];
                user1_loc[1] += delta[user_move[0][i]][1];

                user2_loc[0] += delta[user_move[1][i]][0];
                user2_loc[1] += delta[user_move[1][i]][1];

                temp1 = count_charge_place(user1_loc[0],user1_loc[1]);
                temp2 = count_charge_place(user2_loc[0],user2_loc[1]);

                System.out.println(i + " "+ res);
                for (Charger charger : temp1) {
                    System.out.print(charger);
                }
                System.out.println();
                for (Charger charger : temp2) {
                    System.out.print(charger);
                }
                System.out.println();

                calc(temp1,temp2);

            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    // 음.. 아래 함수로 계산해서 그 조건 안에 들면 해주는게 좋은가??
    // 아니면 그냥 나처럼 배열 한번 더 만들어서 하는게 좋은가?
//    private static int cal_dis(int[] place1, int[] place2) {
//        return Math.abs(place1[0]-place2[0]) + Math.abs(place1[1] - place2[1]);
//    }

    private static void calc(ArrayList<Charger> temp1, ArrayList<Charger> temp2){
        if (temp1.isEmpty() && temp2.isEmpty()) return;

        if (temp1.isEmpty()) {
            res += temp2.get(0).p;
            return;
        }
        if (temp2.isEmpty()) {
            res += temp1.get(0).p;
            return;
        }
        if (temp1.get(0).i != temp2.get(0).i) {
            res += temp1.get(0).p + temp2.get(0).p;
            return;
        }
        if (temp1.size() == 1 && temp2.size() == 1){
            res += temp1.get(0).p;
            return;
        }
        int tmp1 = 0;
        int tmp2 = 0;
        if (temp1.size() > 1) tmp1 = temp1.get(1).p;
        if (temp2.size() > 1) tmp2 = temp2.get(1).p;
        res += Math.max(temp1.get(0).p + tmp2, tmp1 + temp2.get(0).p);
    }
    private static boolean outOfIndexCheck(int y, int x){
        return 0 <= y && y < 10 && 0<= x && x<10;
    }

    private static ArrayList<Charger> count_charge_place(int y, int x){
        ArrayList<Charger> charges = new ArrayList<>();
        for(int i = 0; i < a ;i++) {
            Charger c = chargers[i];
//            System.out.printf(x +" "+ c.x +" " + y+" "+c.y+" "+c.c+"\n");
            if(Math.abs(x-c.x) + Math.abs(y-c.y) <= c.c) {
                charges.add(c);
            }
        }
        return charges;
    }
}
