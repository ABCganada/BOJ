import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            swap(arr, a-1, b-1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(arr[i]+" ");
        }
        bw.close();
    }

    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
