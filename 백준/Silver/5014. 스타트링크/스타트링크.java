import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int f, s, g, u, d;
    static int[] visit;
    static Queue<Integer> q = new LinkedList<>();

    static void bfs(int k) {
        visit[k] = 1;
        q.offer(k);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now + u <= f) {
                if (visit[now + u] == 0) {
                    visit[now + u] = visit[now] + 1;
                    q.offer(now + u);
                }
            }

            if (now - d > 0) {
                if (visit[now - d] == 0) {
                    visit[now - d] = visit[now] + 1;
                    q.offer(now - d);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visit = new int[f + 1];

        bfs(s);

        if (visit[g] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(visit[g] - 1);
        }
    }
}