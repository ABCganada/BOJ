import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] dp;



    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];

        dp[1][0] = 1;
        dp[1][1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
            dp[i][1] = dp[i - 1][0] % 10007;
        }

        System.out.println((dp[n][0] + dp[n][1]) % 10007);
    }
}