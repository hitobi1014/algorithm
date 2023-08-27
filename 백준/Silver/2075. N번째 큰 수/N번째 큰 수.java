import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * N번째 큰 수
 * N*N = N^2
 */
public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 모든 수는 자신의 한 칸 위에있는 수 보다 크다..
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N; i++) {
            if (i==N-1){
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
        }

    }

}