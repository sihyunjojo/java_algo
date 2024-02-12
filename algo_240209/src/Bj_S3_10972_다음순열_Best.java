import java.util.Scanner;

public class Bj_S3_10972_다음순열_Best {
    static void next_permutation(int[] a) {
        int i = a.length-1;

        while(i>0) {
            if(a[i]>a[i-1]) break;
            i--;
        }

        if(i==0) {
            System.out.println(-1);
            return;
        }

        int j = a.length-1;

        while(a[j]<=a[i-1]) {
            j--;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;

        while(i<j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        for(int y:a)
            System.out.print(y+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();

        next_permutation(a);
    }
}