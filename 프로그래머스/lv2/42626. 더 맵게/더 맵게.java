import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
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