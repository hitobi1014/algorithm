import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<int[]>();

            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(new int[] {j, num});
            }

            int cnt = 0;

            while (true) {
                int[] pollQ = q.poll();
                boolean check = true;

                for (int[] num: q){
                    if (num[1] > pollQ[1]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    cnt++;
                    if (pollQ[0] == M) break;
                } else {
                    q.add(pollQ);
                }
            }

            System.out.println(cnt);
        }
    }
}