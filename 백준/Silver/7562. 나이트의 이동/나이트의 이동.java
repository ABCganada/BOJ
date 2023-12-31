import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, n;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int bfs(int start, int target) {
        int[][] visit = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        visit[start / n][start % n] = 1;
        queue.offer(new int[]{start / n, start % n});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 8; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (visit[x][y] == 0) {
                        visit[x][y] = visit[nowX][nowY] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }

                if (x == target / n && y == target % n) {
                    return visit[target / n][target % n] - 1;
                }
            }
        }

        return visit[target / n][target % n] - 1;
    }

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int start = s1 * n + s2;

            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int target = t1 * n + t2;

            sb.append(bfs(start, target) + "\n");
        }

        System.out.println(sb);
    }
}