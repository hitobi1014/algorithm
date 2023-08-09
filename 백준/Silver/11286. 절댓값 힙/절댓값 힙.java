import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N;
    private static PriorityQueue<Integer> pq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1)==Math.abs(o2)) return Integer.compare(o1, o2);
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        });

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {
                printDelete();
            }
        }
        System.out.println(sb.toString());
    }
    public static void printDelete() {
        if (pq.isEmpty()) {
            sb.append(0).append('\n');
            return;
        }
        sb.append(pq.poll()).append('\n');
    }
}