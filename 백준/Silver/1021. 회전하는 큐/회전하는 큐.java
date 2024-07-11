import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] findNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		findNum = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			findNum[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		/*
		 * step01. 찾으려는 수의 위치가 현재 큐에서 어디에 더 가까운지 찾기
		 * step02.
		 *  - 중앙보다 앞쪽에 있으면 앞쪽 숫자 뒤로 보내기
		 *  - 중앙보다 뒤쪽에 있으면 뒤쪽 숫자 앞으로 보내기
		 * step03. 숫자 poll
		 */
		int cnt=0;

		for (int i = 0; i < findNum.length; i++) {
			int num = findNum[i];
			int idx = queue.indexOf(num);

			int half = queue.size() / 2;

			while (!queue.isEmpty() && queue.peek() != num) {
				if (idx > half) {
					int last = queue.pollLast();
					queue.offerFirst(last);
				} else {
					int first = queue.pollFirst();
					queue.offerLast(first);
				}
				cnt++;
			}

			queue.poll();
		}

		System.out.println(cnt);
	}
}