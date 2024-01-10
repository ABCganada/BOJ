import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] cnt = new int[2];
    static int[][] map;

    static void partition(int row, int col, int size) {

        if (check(row, col, size)) {
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row + newSize, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }

        cnt[color]++;
        return true;
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);

    }
}