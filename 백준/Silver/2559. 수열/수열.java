import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static int[] temper;
    static int[] seq;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        temper = new int[n];
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            seq[k - 1] += temper[i];
        }

        int max = seq[k - 1];

        for (int i = k; i < n; i++) {
            seq[i] = seq[i - 1] + temper[i] - temper[i - k];
            max = Math.max(max, seq[i]);
        }

        System.out.println(max);
    }
}