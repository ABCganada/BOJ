import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, day;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static ArrayList<ArrayList<int[]>> q = new ArrayList<>();

    static void bfs() {

        while (!q.get(day).isEmpty()) {
            q.add(day + 1, new ArrayList<>());

            for (int i = 0; i < q.get(day).size(); i++) {
                int[] now = q.get(day).get(i);
                int nowX = now[0];
                int nowY = now[1];

                for (int j = 0; j < 4; j++) {
                    int x = nowX + dx[j];
                    int y = nowY + dy[j];

                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (map[x][y] == 0) {
                            map[x][y] = day + 1;
                            q.get(day + 1).add(new int[]{x, y});
                        }
                    }
                }
            }

            day++;
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

        q.add(day, new ArrayList<>());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.get(day).add(new int[]{i, j});
                }
            }
        }

        bfs();

        if (checkTomato()) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }
}