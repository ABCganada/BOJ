import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, cntRecursive, cntDP;

    public static int fibRecursive(int n) {
        if (n == 1 || n == 2) {
            cntRecursive++;
            return 1;
        } else {
            return fibRecursive(n-1) + fibRecursive(n-2);
        }
    }

    public static int fibDP(int n) {
        int[] f = new int[n];

        f[0] = f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            cntDP++;
        }

        return f[n-1];
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        int n1 = fibRecursive(n);
        int n2 = fibDP(n);
        
        System.out.println(cntRecursive + " " + cntDP);
    }
}