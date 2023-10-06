import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] target, arr;
    static int n;
    static int flag = 0;
    static int eq;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        target = new int[n];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            target[i] = Integer.parseInt(input[i]);
        }

        eq = isEqual(arr);
        if(eq != -1){
            qSort(arr, 0, n-1);
        } else{
            flag = 1;
        }

        System.out.println(flag);
    }

    public static void qSort(int[] arr, int p, int r){

        if(flag == 1){
            return;
        }

        if(p < r){
            int q = partition(arr, p, r);
            qSort(arr, p, q-1);
            qSort(arr, q+1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {

        int pivot = arr[r];
        int i = p-1;

        for(int j=p; j<=r-1; j++){
            if(arr[j] <= pivot){
                swap(arr, ++i, j);
            }
        }

        if(i+1 != r){
            swap(arr, i+1, r);
        }

        return i+1;
    }

    static int isEqual(int[] arr){
        for(int i=0; i<n; i++){
            if(arr[i] != target[i]){
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        if(eq == i || eq == j){
            eq = isEqual(arr);

            if(eq == -1){
                flag = 1;
            }
        }
    }
}