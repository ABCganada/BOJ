import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    static void dfs(int v) {
        for (int i = 0; i < lists.get(v).size(); i++) {
            int u = lists.get(v).get(i);

            if (u == 1) {
                continue;
            }

            if (parent[u] == 0) {
                parent[u] = v;
                dfs(u);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            lists.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            lists.get(v1).add(v2);
            lists.get(v2).add(v1);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}