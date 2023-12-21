import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, num;
    static int[][] house;
    static boolean[][] visit;
    static ArrayList<Integer> cnt = new ArrayList<>();

    static Queue<Integer> queue = new LinkedList<>();

    static void bfs(int x, int y) {

        visit[x][y] = true;
        int count = 0;
        int idx = x * 100 + y;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            count++;
            int start = queue.poll();
            int startX = start / 100;
            int startY = start % 100;

            house[startX][startY] = num;

            if (startX - 1 >= 0 && house[startX - 1][startY] == 1 && visit[startX - 1][startY] == false) {
                visit[startX - 1][startY] = true;
                queue.offer((startX - 1) * 100 + startY);
            }

            if (startX + 1 < n && house[startX + 1][startY] == 1 && visit[startX + 1][startY] == false) {
                visit[startX + 1][startY] = true;
                queue.offer((startX + 1) * 100 + startY);
            }

            if (startY - 1 >= 0 && house[startX][startY - 1] == 1 && visit[startX][startY - 1] == false) {
                visit[startX][startY - 1] = true;
                queue.offer(startX * 100 + (startY - 1));
            }

            if (startY + 1 < n && house[startX][startY + 1] == 1 && visit[startX][startY + 1] == false) {
                visit[startX][startY + 1] = true;
                queue.offer(startX * 100 + (startY + 1));
            }
        }

        cnt.add(count);
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        house = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (house[i][j] == 1 && visit[i][j] == false) {
                    num++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(num);

        Collections.sort(cnt);

        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }
}