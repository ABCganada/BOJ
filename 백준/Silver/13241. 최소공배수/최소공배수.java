import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long A = sc.nextInt();
        long B = sc.nextInt();

        if(A < B){
            long tmp = A;
            A = B;
            B = tmp;
        }
        long N = A*B / gcd(A, B);

        System.out.println(N);
    }

    static long gcd(long A, long B){
        if(A%B == 0)
            return B;
        return gcd(B, A%B);
    }
}
