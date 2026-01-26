import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][2];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(info[0]);
        for (int i = 1; i < n; i++) {
            int[] cur = info[i];
            int[] prev = stack.peek();
            if (cur[1] < prev[1]) {
                stack.pop();
                stack.push(cur);
            } else {
                if (prev[1] <= cur[0]) {
                    stack.push(cur);
                }
            }
        }

        System.out.println(stack.size());
    }
}