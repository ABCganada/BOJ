import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;

    static int[] visit = new int[100001];

    static Queue<Integer> queue = new LinkedList<>();

    static int bfs(int N, int K) {
        visit[N] = 1;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now - 1 >= 0 && visit[now - 1] == 0) {
                visit[now - 1] = visit[now] + 1;
                queue.offer(now - 1);
            }

            if (now + 1 <= 100000 && visit[now + 1] == 0) {
                visit[now + 1] = visit[now] + 1;
                queue.offer(now + 1);
            }

            if (now * 2 <= 100000 && visit[now * 2] == 0) {
                visit[now * 2] = visit[now] + 1;
                queue.offer(now * 2);
            }

            if (visit[K] != 0) {
                break;
            }
        }

        return visit[K];
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int ans = bfs(n, k);

        System.out.println(ans - 1);

    }
}