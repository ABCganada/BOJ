import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, cntA, cntB, cntC;
    static int[][] map;

    static void partition(int x, int y, int size) {
        int paper = map[x][y];

        if (check(x, y, size)) {
            if (paper == -1) {
                cntA++;
            } else if (paper == 0) {
                cntB++;
            } else {
                cntC++;
            }
        } else {
            int newSize = size / 3;
            partition(x, y, newSize);
            partition(x, y + newSize, newSize);
            partition(x, y + newSize * 2, newSize);

            partition(x + newSize, y, newSize);
            partition(x + newSize, y + newSize, newSize);
            partition(x + newSize, y + newSize * 2, newSize);

            partition(x + newSize * 2, y, newSize);
            partition(x + newSize * 2, y + newSize, newSize);
            partition(x + newSize * 2, y + newSize * 2, newSize);
        }
    }

    static boolean check(int x, int y, int size) {
        int paper = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != paper) {
                    return false;
                }
            }
        }

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
        System.out.println(cntA);
        System.out.println(cntB);
        System.out.println(cntC);
    }
}