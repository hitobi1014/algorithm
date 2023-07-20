package programmers;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;


        System.out.println(solution(scoville, K));

    }

    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pr = new PriorityQueue<>();

        for (int i : scoville) {
            pr.add(i);
        }

        while (pr.peek() < K && pr.size() > 1) {
            answer++;
            int a = pr.poll();
            int b = pr.poll();
            pr.add(a + (b * 2));
        }
        if (pr.peek() < K) answer = -1;

        return answer;
    }

}
