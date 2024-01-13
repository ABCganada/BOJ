import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    static int[] safetyZone = new int[101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] makeNewMap(int k) {
        int[][] newMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= k) {
                    newMap[i][j] = 0;
                } else {
                    newMap[i][j] = 1;
                }
            }
        }

        return newMap;
    }

    static void dfs(int h, boolean[][] visit, int x, int y) {

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] >= h && !visit[nx][ny]) {
                    dfs(h, visit, nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        safetyZone[1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = map[i][j];
                if (safetyZone[h] == 0) {
                    boolean[][] visit = new boolean[n][n];
                    int cnt = 0;

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (map[x][y] >= h && !visit[x][y]) {
                                cnt++;
                                dfs(h, visit, x, y);
                            }
                        }
                    }

                    safetyZone[map[i][j]] = cnt;
                }
            }
        }

        int max = safetyZone[1];
        for (int i = 2; i <= 100; i++) {
            max = Math.max(max, safetyZone[i]);
        }

        System.out.println(max);
    }
}