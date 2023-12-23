import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int m, n, k, worms;
    static int[][] cabbages;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Integer> queue = new LinkedList<>();

    static void bfs(int x, int y) {
        visit[x][y] = true;
        queue.offer(50 * x + y);

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = idx / 50 + dx[i];
                int ny = idx % 50 + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (cabbages[nx][ny] == 1 && visit[nx][ny] == false) {
                        visit[nx][ny] = true;
                        queue.offer(nx * 50 + ny);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int tests = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tests; t++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            cabbages = new int[m][n];
            visit = new boolean[m][n];
            worms = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbages[x][y] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cabbages[i][j] == 1 && visit[i][j] == false) {
                        worms++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(worms + "\n");
        }

        System.out.println(sb);
    }
}