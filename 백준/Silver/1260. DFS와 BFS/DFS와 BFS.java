import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, v, cnt;
    static int[][] eMatrix;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int start) {
        visit = new boolean[1001];

        q.offer(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int vertex = q.poll();

            for (int i = 1; i <= n; i++) {
                if (eMatrix[vertex][i] == 1 && visit[i] == false) {
                    q.offer(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void dfs(int start) {

        visit[start] = true;
        System.out.print(start + " ");

        if (cnt == n) {
            return;
        }
        cnt++;

        for (int i = 1; i <= n; i++) {
            if (eMatrix[start][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        eMatrix = new int[1001][1001];
        visit = new boolean[1001];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            eMatrix[x][y] = eMatrix[y][x] = 1;
        }

        dfs(v);
        System.out.println();

        bfs(v);
        System.out.println();
    }
}