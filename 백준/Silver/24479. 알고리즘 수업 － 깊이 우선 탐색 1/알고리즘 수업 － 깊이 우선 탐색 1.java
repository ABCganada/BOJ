import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, r, cnt;
    static int[] visit;

    static ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();

    public static void dfs(int start) {
        visit[start] = cnt;

        for (int i = 0; i < edgeList.get(start).size(); i++) {
            int vNum = edgeList.get(start).get(i);

            if (visit[vNum] == 0) {
                cnt++;
                dfs(vNum);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        //방문 리스트 생성
        visit = new int[n+1];
        //정점 수만큼 edgeList 생성
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

        for (int i = 0; i < edgeList.size(); i++) {
            Collections.sort(edgeList.get(i));
        }

        cnt = 1;
        dfs(r);

        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]+"\n");
        }
        System.out.println(sb);
    }
}