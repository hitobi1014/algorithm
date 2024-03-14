import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < progresses.length; i++) {
			double d = (double)(100 - progresses[i]) / speeds[i];
			int x = (int)Math.ceil(d);
			queue.offer(x);
		}

		if (queue.isEmpty()) return answer;

		ArrayList<Integer> list = new ArrayList<>();

		int top = queue.poll();
		int cnt = 1;

		while (!queue.isEmpty()) {
			if (top < queue.peek()) {
				list.add(cnt);
				cnt=1;
				top = queue.poll();
				continue;
			}
			cnt++;
			queue.poll();
		}
		list.add(cnt);
		answer = list.stream().mapToInt(i->i).toArray();

		return answer;
    }
}