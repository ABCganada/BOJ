import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] house;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        house = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    house[i][j] += Math.min(house[i - 1][1], house[i - 1][2]);
                } else if (j == 1) {
                    house[i][j] += Math.min(house[i - 1][0], house[i - 1][2]);
                } else {
                    house[i][j] += Math.min(house[i - 1][0], house[i - 1][1]);
                }
            }
        }

        int minCost = Math.min(house[n - 1][0], Math.min(house[n - 1][1], house[n - 1][2]));
        System.out.println(minCost);
    }
}