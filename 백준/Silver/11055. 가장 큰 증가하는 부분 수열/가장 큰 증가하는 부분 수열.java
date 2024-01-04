import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] seq;
    static int[] dp;
    static int[] sum;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        seq = new int[n];
        dp = new int[n];
        sum = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = seq[0];
        sum[0] = seq[0];
        for (int i = 1; i < n; i++) {
            dp[i] = seq[i];

            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + seq[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}