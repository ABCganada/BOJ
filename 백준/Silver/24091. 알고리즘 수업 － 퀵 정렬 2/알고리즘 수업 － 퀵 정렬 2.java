import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, k;
    static int cnt = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[] arr = new int[n];

        input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        qSort(arr, 0, n-1);

        if(cnt < k){
            System.out.println(-1);
        }
    }

    public static void qSort(int[] arr, int p, int r){
        if(flag){
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
                cnt++;
                swap(arr, ++i, j);

                if(cnt == k){
                    flag = true;

                    StringBuilder sb = new StringBuilder();
                    for(int t=0; t<n; t++){
                        sb.append(arr[t] + " ");
                    }
                    System.out.println(sb);
                    break;
                }
            }
        }

        if(i+1 != r){
            cnt++;
            swap(arr, i+1, r);

            if(cnt == k){
                flag = true;

                StringBuilder sb = new StringBuilder();
                for(int t=0; t<n; t++){
                    sb.append(arr[t] + " ");
                }
                System.out.println(sb);
            }
        }

        return i+1;
    }


    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}