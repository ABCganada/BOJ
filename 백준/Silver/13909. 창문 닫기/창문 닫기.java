import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        int i=1;
        while(N >=i*i)
            i++;

        System.out.println(i-1);
    }

//    static int[] openAndCloseWindows(int[] windows, int n){
//        int i = n;
//        while(i < windows.length){
//            if(windows[i] == 1)
//                windows[i]--;
//            else
//                windows[i]++;
//
//            i += (n+1);
//        }

//            System.out.println(n + Arrays.toString(windows));
//            return windows;
//        }
}
