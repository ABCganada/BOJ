import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, max = 0;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> q = new LinkedList<>();

    static void bfs() {

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (map[x][y] == 0) {
                        map[x][y] = map[nowX][nowY] + 1;
                        q.offer(new int[]{x, y});
                        if (max < map[x][y]) {
                            max = map[x][y];
                        }
                    }
                }
            }
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
        }

        bfs();

        if (checkTomato()) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }
}