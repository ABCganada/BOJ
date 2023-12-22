import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;
    static int n;

    static int[] dp;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            int sum = dp[i - 1] + arr[i];

            dp[i] = Math.max(sum, arr[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}