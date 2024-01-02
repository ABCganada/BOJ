import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] drink;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        drink = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(drink[1]);
            return;
        } else if (n == 2) {
            System.out.println(drink[1] + drink[2]);
            return;
        }

        dp[1] = drink[1];
        dp[2] = drink[1] + drink[2];

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + drink[i - 1]) + drink[i];

            if (dp[i] < dp[i - 1]) {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[n]);
    }
}