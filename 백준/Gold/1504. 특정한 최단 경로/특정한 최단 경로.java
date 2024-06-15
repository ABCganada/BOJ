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
    public int compareTo(Node node) {
        return this.w - node.w;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int INIT = 9999999;
    static int vNum, eNum;
    static int[] dist;
    static ArrayList<ArrayList<Node>> arrayList = new ArrayList<>();

    public static int dijk(int start, int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[vNum + 1];
        Arrays.fill(dist, INIT);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.v] == true) {
                continue;
            }

            visit[cur.v] = true;

            if (cur.v == target) {
                break;
            }

            for (int i = 0; i < arrayList.get(cur.v).size(); i++) {
                Node node = arrayList.get(cur.v).get(i);
                if (dist[node.v] > dist[cur.v] + node.w) {
                    dist[node.v] = dist[cur.v] + node.w;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }

        return dist[target];
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vNum; i++) {
            arrayList.add(i, new ArrayList<>());
        }

        dist = new int[vNum + 1];

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arrayList.get(u).add(new Node(v, w));
            arrayList.get(v).add(new Node(u, w));
        }

        int v1, v2;
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int n1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, vNum);
        int n2 = dijk(1, v2) + dijk(v2, v1) + dijk(v1, vNum);

        if (n1 >= INIT) {
            System.out.println(-1);
        } else if (n1 < n2) {
            System.out.println(n1);
        } else {
            System.out.println(n2);
        }

    }
}