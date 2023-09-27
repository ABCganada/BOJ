import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;
    static int n, k;

    public static void mergeSort(int[] arr, int startIdx, int endIdx){

        if(cnt == k){
            return;
        }

        if(startIdx < endIdx){
            int midIdx = (endIdx + startIdx) / 2;
            mergeSort(arr, startIdx, midIdx);
            mergeSort(arr, midIdx+1, endIdx);
            merge(arr, startIdx, midIdx, endIdx);
        }
    }

    public static void merge(int[] arr, int startIdx, int midIdx, int endIdx){

        if(cnt == k){
            return;
        }

        int i = startIdx;
        int j = midIdx+1;
        int t = 0;
        int[] tmp = new int[endIdx - startIdx + 1];

        while(i<=midIdx && j<=endIdx){
            if(arr[i] < arr[j]){
                tmp[t++] = arr[i++];
            } else{
                tmp[t++] = arr[j++];
            }
        }

        while(i<=midIdx){
            tmp[t++] = arr[i++];
        }

        while(j<=endIdx){
            tmp[t++] = arr[j++];
        }

        t = 0;
        i = startIdx;

        while(i<=endIdx){
            arr[i++] = tmp[t++];
            cnt++;

            if(cnt == k){
                StringBuilder stringBuilder = new StringBuilder();
                for(int idx=0; idx<n; idx++){
                    stringBuilder.append(arr[idx]+" ");
                }
                System.out.println(stringBuilder);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[] arr = new int[n];

        input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        mergeSort(arr,0, n-1);

        if(cnt < k){
            System.out.println(-1);
        }
    }
}