import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, cnt;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    static void dfs(int start) {
        visit[start] = 1;
        cnt++;

        for (int i = 0; i < arrayList.get(start).size(); i++) {
            int target = arrayList.get(start).get(i);

            if (visit[target] == 0) {
                dfs(target);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arrayList.add(i, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList.get(x).add(y);
            arrayList.get(y).add(x);
        }

        dfs(1);

        System.out.println(cnt - 1);
    }
}