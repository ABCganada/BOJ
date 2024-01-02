import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[][] dp;

    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][1] % mod;

            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }

            dp[i][9] = dp[i - 1][8] % mod;
        }

        long cnt = 0;
        for (int i = 1; i < 10; i++) {
            cnt = (cnt + dp[n][i]) % mod;
        }

        System.out.println(cnt);
    }
}