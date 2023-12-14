import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, r, cnt;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs(int v) {
        cnt = 1;
        visit[v] = cnt;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < edgeList.get(u).size(); i++) {
                if (visit[edgeList.get(u).get(i)] == 0) {
                    visit[edgeList.get(u).get(i)] = ++cnt;
                    queue.offer(edgeList.get(u).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visit = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edgeList.get(x).add(y);
            edgeList.get(y).add(x);
        }

        for (int i = 1; i < edgeList.size(); i++) {
            Collections.sort(edgeList.get(i));
        }

        bfs(r);

        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i] + "\n");
        }

        System.out.println(sb);
    }
}