import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미친놈 .... 문제 좀 재대로 읽고 코딩하자 제발....... 아..... 인생 날라갓네 .
public class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int game_count = 9;
    static final int card_count = 18;
    static int all_game_count = 1;
    static boolean[] isused, sortcard;
    static int[] your_cards, my_cards;
    static int win_result;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputFile/s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 9; i++){
            all_game_count *=  i;
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            your_cards = new int[9];
            my_cards = new int[9];
            sortcard = new boolean[card_count+1];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < card_count/2; i++){
                your_cards[i] = Integer.parseInt(st.nextToken());
                sortcard[your_cards[i]] = true;
            }

            // 이 기술 멋잇다.
            for(int i = 1, j = 0; i <= card_count; i++){
                if (!sortcard[i]) {
                    my_cards[j++] = i;
                }
            }

            isused = new boolean[game_count];
//            System.out.println(Arrays.toString(my_cards));
//            System.out.println(Arrays.toString(your_cards));
//            System.out.println(Arrays.toString(isused));
            win_result = 0;
            game(0,0,0);
            bw.write("#"+tc+" "+win_result+ " " + (all_game_count - win_result) + "\n");

        }
        bw.flush();
        bw.close();
    }

    private static void game(int count, int my_score, int your_score){
        if (count == game_count) {
            if (my_score > your_score) win_result += 1;
            return;
        }
        for (int i = 0; i < game_count; i++){
            if (isused[i]){
                continue;
            }
            isused[i] = true;

            int tmp_score = my_cards[count] + your_cards[i];
            if (my_cards[count] < your_cards[i]){
                game(count + 1,my_score + tmp_score, your_score);
            }
            else {
                game(count + 1, my_score, your_score + Math.abs(tmp_score));
            }

            isused[i] = false;
        }
    }
}
