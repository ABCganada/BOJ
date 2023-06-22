import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int a = 1;
        for(int i=0; i<K; i++){
            a *= N;
            N--;
        }

        int b = 1;
        for(int i=2; i<=K; i++){
            b *= i;
        }

        System.out.println(a / b);
    }
}
