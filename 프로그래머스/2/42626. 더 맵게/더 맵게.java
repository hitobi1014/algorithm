import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
		int answer = 0;
		Integer a, b;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : scoville) {
			pq.offer(x);
		}

		while (pq.peek() < K) {
			if (pq.size() < 2) {
				return -1;
			} else {
				a = pq.poll();
				b = pq.poll();

				a += (b * 2);
				pq.offer(a);
				answer++;
			}
		}

		return answer;
    }
}