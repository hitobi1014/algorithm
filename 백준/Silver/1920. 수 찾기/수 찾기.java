import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M;i++){
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder();

        A:for (int i=0; i<M; i++) {
            int key = mArr[i];
            int low = 0;
            int high = N-1;

            while (low <= high){
                int mid = (low+high)/2;

                if (key == nArr[mid]) {
                    sb.append(1).append('\n');
                    continue A;
                } else if (key > nArr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            sb.append(0).append('\n');
        }

        System.out.println(sb);
    }


}