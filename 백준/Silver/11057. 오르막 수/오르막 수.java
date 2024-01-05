import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] dp;  //dp[i][j]: 길이 i, j로 시작하는 수
    static int mod = 10007;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            dp[i][9] = 1;

            for (int j = 8; j >= 0; j--) {
                dp[i][j] = ((dp[i - 1][j] % mod) + (dp[i][j + 1]) % mod) % mod;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % mod;
        }

        System.out.println(sum);
    }
}