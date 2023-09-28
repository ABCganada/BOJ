import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] arr1, arr2;
    static int flag = 0;
    static int now = 0;

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
        int[] tmp = new int[endIdx-startIdx+1];

        while(i <= midIdx && j <= endIdx){
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

            if(flag < 1){
                while(true){
                    if(arr[now] == arr2[now]){
                        if(now == arr.length-1){
                            flag = 1;
                            break;
                        }
                        now++;
                    } else{
                        break;
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr1 = new int[n];
        arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        if(Arrays.equals(arr1, arr2)){
            flag = 1;
            System.out.println(flag);
            return;
        }

        mergeSort(arr1, 0, n-1);

        System.out.println(flag);
    }
}