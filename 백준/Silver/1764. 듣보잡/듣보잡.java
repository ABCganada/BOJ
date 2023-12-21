import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String[] dd;
    static String[] bd;

    static ArrayList<String> ddbd = new ArrayList<>();

    static int n, m;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dd = new String[n];
        bd = new String[m];

        for (int i = 0; i < n; i++) {
            dd[i] = br.readLine();
        }

        Arrays.sort(dd);

        for (int i = 0; i < m; i++) {
            bd[i] = br.readLine();
        }

        Arrays.sort(bd);

        int x = 0;
        int y = 0;

        while (x < n && y < m) {
            if (dd[x].equals(bd[y])) {
                ddbd.add(dd[x]);
                x++;
                y++;
            } else if (dd[x].compareTo(bd[y]) < 0) {
                x++;
            } else {
                y++;
            }
        }

        System.out.println(ddbd.size());
        for (int i = 0; i < ddbd.size(); i++) {
            System.out.println(ddbd.get(i));
        }
    }
}