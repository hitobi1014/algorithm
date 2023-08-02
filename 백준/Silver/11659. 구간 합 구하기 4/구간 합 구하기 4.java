import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] += sum;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int calc = arr[j] - arr[i - 1];
            System.out.println(calc);
        }
    }

}