import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int game_count = 9;
    static final int card_count = 18;
    static int all_game_count = 1;
    static boolean[] isused,sortcard;
    static int[] your_cards,my_cards;
    static int win_result;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputFile/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            your_cards = new int[9];
            sortcard = new boolean[card_count];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < card_count/2; i++){
                your_cards[i] = Integer.parseInt(st.nextToken());
                sortcard[your_cards[i]] = false;
            }
            int a = 0;
            for(int i = 0; i < card_count; i++){
                if (sortcard[i]) my_cards[a] = i;
                a++;
            }

//            for (int i = 1; i <= 9; i++){
//                all_game_count *=  i;
//            }
            System.out.println(Arrays.toString(my_cards));
            System.out.println(Arrays.toString(your_cards));

            isused = new boolean[game_count];

//            game(0,0);
            bw.write("#"+tc+" "+win_result+ " " + (all_game_count - win_result) + "\n");
        }
        bw.flush();
    }
    // 무식하게 다 돌리는게 맞을까??
//    private static void game(int count, int score){
//        if (score > 0) win_result += 1;
//        for (int i = 0; i < game_count; i++){
//            if (your_cards[i] <
//            game(count+1,your_cards[i]);
//        }
//    }
}
