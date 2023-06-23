import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        int max, min;
        max = min = num[0];

        for(int i=1; i<N; i++){
            max = max < num[i] ? num[i] : max;
            min = min > num[i] ? num[i] : min;
        }

        System.out.println(max*min);

    }
}
