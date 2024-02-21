import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어디서든지 true를 해주면 false를 해줘야한다.
public class Main {
    static int l,c,mo_place[];
    static char[] arr;
    static boolean[] isused;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 서로 다른 L개의 알파벳 소문자들로 구성되며
        // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        List<Character> mo = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
        List<Character> arr_mo = new ArrayList<>();
        List<Character> arr_ja = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            char cha = st.nextToken().charAt(0);
            if (mo.contains(cha))  arr_mo.add(cha);
            if (!mo.contains(cha))  arr_ja.add(cha);
        }

        mo_place = new int[2];
        isused = new boolean[c];
    }

    // 모음 빼두는 답  햐
    static void c(int start, int count){
        if (count == 2){
            p()
            return;
        }
        for (int i = 0; i < l; i++){
            if(isused[i]) continue;
            isused[i] = true;
            c(i+1,count+1);
            isused[i] = false;
        }
    }

    static void p(int count){

    }
}

