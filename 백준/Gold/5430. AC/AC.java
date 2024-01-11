import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t;
    static boolean direction;
    static boolean flag;

    static void AC(String p, Deque<Integer> dq) {

        for (char cmd : p.toCharArray()) {
            if (cmd == 'R') {
                direction = !direction;
                continue;
            }

            if (dq.isEmpty()) {
                sb.append("error\n");
                return;
            }

            if (direction) {
                dq.removeFirst();
            } else {
                dq.removeLast();
            }
        }

        makeString(dq);
    }

    static void delete(Deque<Integer> deque) {
        deque.removeFirst();
    }

    static void makeString(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            sb.append("[]\n");
            return;
        }

        sb.append("[");

        if (direction) {
            sb.append(deque.pollFirst());

            while (!deque.isEmpty()) {
                sb.append(",").append(deque.pollFirst());
            }
        } else {
            sb.append(deque.pollLast());

            while (!deque.isEmpty()) {
                sb.append(",").append(deque.pollLast());
            }
        }

        sb.append("]").append("\n");
    }

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            direction = true;
            flag = true;

            Deque<Integer> dq = new ArrayDeque<>();
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for (int j = 0; j < n; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(p, dq);
        }

        System.out.println(sb);
    }
}