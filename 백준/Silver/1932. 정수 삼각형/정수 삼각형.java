import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arrayList.add(i, new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arrayList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                int n1 = 0, n2 = 0;
                int target = arrayList.get(i).get(j);

                if (j - 1 >= 0 && arrayList.get(i - 1).get(j - 1) != null) {
                    n1 = target + arrayList.get(i - 1).get(j - 1);
                }

                if (j < arrayList.get(i - 1).size() && arrayList.get(i - 1).get(j) != null) {
                    n2 = target + arrayList.get(i - 1).get(j);
                }

                arrayList.get(i).set(j, Math.max(n1, n2));
            }
        }

        int max = arrayList.get(n-1).get(0);

        for (int i = 1; i < arrayList.get(n - 1).size(); i++) {
            if (max < arrayList.get(n - 1).get(i)) {
                max = arrayList.get(n - 1).get(i);
            }
        }

        System.out.println(max);
    }
}