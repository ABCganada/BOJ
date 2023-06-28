import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] num = new long[T];

        for (int i = 0; i < T; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        br.close();

        printPrime(num);
    }

    static BigInteger findPrime(BigInteger n){

        if(n.isProbablePrime(10)){
            return n;
        } else{
            return n.nextProbablePrime();
        }

    }

    static void printPrime(long[] num) throws IOException{

        for(int i=0; i<num.length; i++){
            BigInteger n = new BigInteger(String.valueOf(num[i]));
            System.out.println(findPrime(n));
        }
    }
}
