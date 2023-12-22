import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[] p;
    static int t;

    static long dp(int n) {
        if (p[n] != 0) {
            return p[n];
        }

        return p[n] = dp(n - 1) + dp(n - 5);
    }

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        p = new long[101];

        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp(n) + "\n");
        }

        System.out.println(sb);
    }
}