import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedList<Integer> deque = new LinkedList<>();
        int[] idx = new int[m];
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            idx[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<m; i++) {
            int target = idx[i];

            if (check(target, deque)) {
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
            } else {
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(answer);
    }

    public static boolean check(int target, LinkedList<Integer> deque) {
        for (int i = 0; i <= deque.size() / 2; i++) {
            if (target == deque.get(i)) {
                return true;
            }
        }

        return false;
    }
}