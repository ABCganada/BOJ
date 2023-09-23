import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int k;
    static int answer = -1;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];

        input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        mergeSort(arr, 0, n-1);

        System.out.println(answer);
    }

    public static void mergeSort(int[] arr, int startIdx, int endIdx){

        if(startIdx < endIdx){
            int midIdx = (startIdx + endIdx) / 2;
            mergeSort(arr, startIdx, midIdx);
            mergeSort(arr, midIdx+1, endIdx);
            merge(arr, startIdx, midIdx, endIdx);
        }
    }

    public static void merge(int[] arr, int startIdx, int midIdx, int endIdx){

        int i = startIdx;
        int j = midIdx+1;
        int t = 0;

        int[] tmp = new int[endIdx - startIdx + 1];

        while(i <=  midIdx && j <= endIdx){
            if(arr[i] < arr[j]){
                tmp[t++] = arr[i++];
            } else{
                tmp[t++] = arr[j++];
            }
        }

        while(i <= midIdx){
            tmp[t++] = arr[i++];
        }

        while(j <= endIdx){
            tmp[t++] = arr[j++];
        }

        i = startIdx;
        t = 0;
        while(i <= endIdx){
            arr[i++] = tmp[t++];
            cnt++;
            if(cnt == k){
                answer = arr[i-1];
            }
        }
    }
}