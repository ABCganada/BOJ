import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;
    static int[] distance;

    static ArrayList<ArrayList<Node>> edges = new ArrayList<>();

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;

            if (visit[v]) {
                continue;
            }
            
            visit[v] = true;

            for (Node node : edges.get(v)) {
                if (distance[node.v] > distance[v] + node.w) {
                    distance[node.v] = distance[v] + node.w;
                    pq.offer(new Node(node.v, distance[node.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            edges.add(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.get(u).add(new Node(v, w));
        }

        dijkstra(k);

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(distance[i]).append("\n");
        }

        System.out.println(sb);
    }
}