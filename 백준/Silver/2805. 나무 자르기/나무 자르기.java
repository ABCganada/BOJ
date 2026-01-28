import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max) max = trees[i];
        }

        int low = 0;
        int high = max;
        while (low <= high) {
            int line = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (line < trees[i]) {
                    sum += trees[i] - line;
                }
            }

            if(sum >= m) {
                low = line + 1;
            } else {
                high = line - 1;
            }
        }

        System.out.println(low - 1);
    }
}