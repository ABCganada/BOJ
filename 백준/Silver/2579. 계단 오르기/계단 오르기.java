import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, cnt;
    static int[] step;
    static int[] dp;

    static int stepDP(int k) {

        if (k <= 0) {
            return 0;
        }

        if (dp[k] == 0) {
            dp[k] = Math.max(stepDP(k - 2), stepDP(k - 3) + step[k - 1]) + step[k];
        }

        return dp[k];
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        step = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        stepDP(n);


        System.out.println(dp[n]);
    }
}