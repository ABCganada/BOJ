import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Stack<Character> stack = new Stack<>();
    static boolean flag;

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        List<String> tmp = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            
            if (input.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            } else if (input.charAt(i) == '>') {
                flag = false;
                sb.append(input.charAt(i));
                continue;
            }

            if (!flag) {
                if (input.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(input.charAt(i));
                } else {
                    stack.push(input.charAt(i));
                }

            } else {
                sb.append(input.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}