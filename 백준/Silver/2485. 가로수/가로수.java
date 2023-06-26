import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] pos = new int[N];

        for(int i=0; i<N; i++)
            pos[i] = sc.nextInt();

        Arrays.sort(pos);

        int diff;
        int nextPos = pos[N-1] - pos[0];

        for(int i=0; i<N-1; i++) {
            diff = pos[i + 1] - pos[i];
            nextPos = lcm(Math.max(nextPos, diff), Math.min(nextPos, diff));
        }

//        System.out.println("nextPos = " + nextPos);

        int cnt=0;
        for(int i=0; i<N-1; i++){
            if(pos[i+1] - pos[i] != nextPos)
                cnt += (pos[i+1]-pos[i])/nextPos - 1;

        }

        System.out.println(cnt);
    }
    static int lcm(int n1, int n2){
        while(n2 != 0){
            int tmp = n1;
            n1 = n2;
            n2 = tmp % n2;
        }
        return n1;
    }
}
