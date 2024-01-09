import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[][] map;
    static int[][] visit1;
    static int[][] visit2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> q = new LinkedList<>();

    static void bfs1(int x, int y, int cnt) {
        visit1[x][y] = cnt;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nowX][nowY] == map[nx][ny] && visit1[nx][ny] == 0) {
                        visit1[nx][ny] = cnt;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void bfs2(int x, int y, int cnt) {
        visit2[x][y] = cnt;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nowX][nowY] == 'R' || map[nowX][nowY] == 'G') {
                        if (visit2[nx][ny] == 0 && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                            visit2[nx][ny] = cnt;
                            q.offer(new int[]{nx, ny});
                        }
                    } else {
                        if (visit2[nx][ny] == 0 && map[nowX][nowY] == map[nx][ny]) {
                            visit2[nx][ny] = cnt;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visit1 = new int[n][n];
        visit2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit1[i][j] == 0) {
                    bfs1(i, j, cnt);
                    cnt++;
                }
            }
        }

        sb.append(cnt - 1 + " ");

        cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit2[i][j] == 0) {
                    bfs2(i, j, cnt);
                    cnt++;
                }
            }
        }

        sb.append(cnt - 1 + "\n");
        System.out.println(sb);
    }
}