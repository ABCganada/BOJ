import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[][] maze;
    static int[][] paths;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Integer> queue = new LinkedList<>();

    static void bfs() {
        paths[1][1] = 1;
        queue.offer(1 * 101 + 1);

        while (!queue.isEmpty()) {
            int target = queue.poll();
            int x = target / 101;
            int y = target % 101;
            int targetPath = paths[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (maze[nx][ny] == 1 && paths[nx][ny] == 0) {
                        paths[nx][ny] = paths[x][y] + 1;
                        queue.offer(nx * 101 + ny);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n + 1][m + 1];
        paths = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(input.charAt(j-1)));
            }
        }

        bfs();

        System.out.println(paths[n][m]);
    }
}