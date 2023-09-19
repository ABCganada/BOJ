import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int lastIdx = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        int key;

        for(int i=0; i<N; i++){
            key = Integer.parseInt(br.readLine());

            if(key == 0){
                System.out.println(deleteKey());
            } else{
                insertKey(key);
            }
        }
    }

    private static int deleteKey(){
        if(lastIdx == 0){
            return 0;
        }
        int ret = arr[1];

        swap(1, lastIdx--);
        downHeap(1);

        return ret;
    }

    private static void insertKey(int key){
        arr[++lastIdx] = key;

        upHeap(lastIdx);
    }

    private static void upHeap(int i){

        while(i > 1 && arr[i] < arr[i/2]){
            swap(i, i/2);
            i /= 2;
        }
    }

    private static void downHeap(int i){

        while(2*i <= lastIdx){

            int leftChild = 2*i;
            int rightChild = 2*i + 1;
            int largestChild = leftChild;

            if(rightChild <= lastIdx){
                largestChild = arr[leftChild] < arr[rightChild] ? leftChild : rightChild;
            }

            if(arr[i] > arr[largestChild]){
                swap(i, largestChild);
                i = largestChild;
            } else{
                break;
            }
        }
    }

    private static void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}