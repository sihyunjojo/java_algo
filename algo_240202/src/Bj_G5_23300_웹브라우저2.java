import java.io.*;
import java.util.*;

// 구현
// 반복문 + 어레이덱 
public class Bj_G5_23300_웹브라우저2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] arr, temp;
    static int n, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        int index = 0;
        int acess_count = 0;
        ArrayDeque<Integer> front = new ArrayDeque<>();
        ArrayDeque<Integer> back = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            System.out.println(command);
            if (st.hasMoreTokens()) {
                int page = Integer.parseInt(st.nextToken());
                front.clear();
                if (acess_count != 0) {
                    back.addFirst(index);
                }
                acess_count++;
                index = page;

            }
            if (command.equals("B")) {
                if (back.isEmpty()) {
                    continue;
                }
                front.addFirst(index);
                index = back.removeFirst();
            }
            if (command.equals("F")) {
                if (front.isEmpty()) {
                    continue;
                }
                back.addFirst(index);
                index = front.removeFirst();
            }
            if (command.equals("C")) {
                ArrayDeque<Integer> temp = new ArrayDeque<>();
                for (int x : back) {
                    if (temp.isEmpty()) {
                        temp.add(x);
                    } else {
                        if (temp.peekLast() != x) {
                            temp.add(x);
                        }
                    }
                }
                back = temp;
//                System.out.println();
//                ArrayDeque<Integer> new_de = new ArrayDeque<>();
//                int ccc = back.size();
//                System.out.println(back);
//                while (ccc > 0) {
//                    Integer tmp = back.pollFirst();
//                    back.addLast(0);
//                    System.out.println("tmp  " + tmp + "ccc   " + ccc);
//                    if (tmp == back.peek()) {
//                        ccc--;
////                        System.out.println(back.peek().getClass());
////                        System.out.println(back.peek());
//                        while (Objects.equals(tmp, back.peek())) {
//                            back.pollFirst();
//                            ccc--;
//                        }
//                        new_de.addLast(tmp);
//                    } else {
//                        new_de.addLast(tmp);
//                        ccc--;
////                        if (ccc == 0){
////                            new_de.addLast(back.pollFirst());
////                        }
//                    }
//                    System.out.println(new_de);
//                }
//                back = new_de;
            }
            System.out.println(index);
            System.out.println(front);
            System.out.println(back + "           " + "dsadasd");
        }
//        [1,2,1,3, [1], 2,]
        System.out.println();
        bw.write(index + "\n");
        if (back.isEmpty()) {
            bw.write(-1 + " ");
        }
        for (Integer i : back) {
            bw.write(i + " ");
        }
        bw.newLine();
        if (front.isEmpty()) {
            bw.write(-1 + " ");
        }
        for (Integer i : front) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}