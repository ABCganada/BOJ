import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int arr[];
    static int lastIdx = 0;

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = sc.nextInt();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        int key;

        for(int i=0; i<N; i++){
//            key = sc.nextInt();
            key = Integer.parseInt(br.readLine());

            if(key == 0){
                System.out.println(deleteKey(arr));
            } else{
                insertKey(arr, key);
            }
        }
    }

    private static int deleteKey(int[] arr){
        if(lastIdx == 0){
            return 0;
        }
        int ret = arr[1];

        swap(arr, 1, lastIdx--);
        downHeap(arr);

        return ret;
    }

    private static void insertKey(int[] arr, int key){
        arr[++lastIdx] = key;

        upHeap(arr);
    }

    private static void upHeap(int[] arr){
        int i = lastIdx;
        int parentIdx = i / 2;

        while(parentIdx > 0){
            if(arr[parentIdx] < arr[i]){
                swap(arr, parentIdx, i);

                i = parentIdx;
                parentIdx /= 2;
            } else{
                break;
            }
        }
    }

    private static void downHeap(int[] arr){
        int i = 1;
        int swapIdx;

        while(2*i <= lastIdx){
            if(2*i <= lastIdx && 2*i + 1 <= lastIdx){
                swapIdx = arr[2*i] > arr[2*i + 1] ? 2*i : 2*i+1;
                if(arr[i] < arr[swapIdx]) {
                    swap(arr, i, swapIdx);
                    i = swapIdx;
                } else{
                    break;
                }
            } else{
                if(arr[i] < arr[2*i]){
                    swap(arr, i, 2*i);
                    i = 2*i;
                } else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}