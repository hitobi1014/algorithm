import java.io.*;
import java.util.*;


public class Main {
	static class Node {
		int start;
		int end;
		int distance;
		public Node (int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}

	static int N, D, answer;
	static List<int[]>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[] distance = new int[D + 1];
		Arrays.fill(distance, 10001);
		List<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int shortcut = Integer.parseInt(st.nextToken());
			/*
			 * 1. 도착지가 목표 도착지보다 크면 pass
			 * 2. 지름길이 도착지 - 시작지보다 크면 pass
			 */
			if (end > D || end-start <= shortcut) continue;
			list.add(new Node(start, end, shortcut));
		}
		list.sort((n1, n2) -> {
			if (n1.start==n2.start) return n1.end - n2.end;
			return n1.start - n2.start;
		});

		int arrayIdx = 0;
		int location = 0;
		distance[0] = 0;
		while (location < D){
			if (arrayIdx < list.size()) {
				Node n = list.get(arrayIdx);
				if (n.start == location) {
					distance[n.end] = Math.min(distance[n.end], distance[location] + n.distance);
					arrayIdx++;
					continue;
				}
			}
			distance[location + 1] = Math.min(distance[location + 1], distance[location] + 1);
			location++;
		}
		System.out.println(distance[D]);
	}
}