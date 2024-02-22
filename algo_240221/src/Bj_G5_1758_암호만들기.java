import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어디서든지 true를 해주면 false를 해줘야한다.
public class Bj_G5_1758_암호만들기 {
    static int l,c;
    static char[] arr;
    static char[] temp;
    static boolean[] isused;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 서로 다른 L개의 알파벳 소문자들로 구성되며
        // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        System.out.println(arr);

        temp = new char[l];
        isused = new boolean[c];

        p(0,0);
    }
    static void p(int start, int count){
        if (count == l){
            if (check_mo_count()){
                System.out.println(temp);
            }
            return;
        }

        for (int i = start; i < c; i++){
            temp[count] = arr[i];
            p(i+1,count+1);
        }
    }

    static boolean check_mo_count(){
        int mo_count = 0;
        int ja_count = 0;
        for (char x : temp) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo_count += 1;
            }
            else { ja_count += 1; }
        }
        return 1 <= mo_count && 2 <= ja_count;
    }
}

