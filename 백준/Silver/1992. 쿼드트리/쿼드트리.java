import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static String ans = "";
    static int[][] map;

    static void partition(int row, int col, int size) {

        if (check(row, col, size)) {
            return;
        }

        ans += "(";
        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);

        ans += ")";
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

        ans += String.valueOf(color);
        return true;
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        partition(0, 0, n);

        System.out.println(ans);

    }
}