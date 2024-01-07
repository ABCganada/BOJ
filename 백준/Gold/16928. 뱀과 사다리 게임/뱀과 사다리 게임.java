import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] map = new int[101];
    static int[] laddersAndSnakes = new int[101];
    static Queue<Integer> q = new LinkedList<>();

    static void bfs() {
        map[1] = 1;
        q.offer(1);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                int k = now + i;

                if (k > 100 || map[k] != 0) {
                    continue;
                }

                map[k] = map[now] + 1;

                if (k == 100) {
                    continue;
                }

                if (laddersAndSnakes[k] != 0) {
                    if (map[laddersAndSnakes[k]] == 0) {
                        map[laddersAndSnakes[k]] = map[now] + 1;
                    }
                    q.offer(laddersAndSnakes[k]);
                } else {
                    q.offer(k);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            laddersAndSnakes[s] = e;
        }

        bfs();

        System.out.println(map[100] - 1);
    }
}