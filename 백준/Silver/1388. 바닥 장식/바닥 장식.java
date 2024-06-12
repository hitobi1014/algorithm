import java.io.*;
import java.util.*;


public class Main {

	static int N,M;
	static char[][] map;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '-') {
					cnt++;
					dfs1(i,j);
				}
			}
		}

		answer += cnt;
		cnt = 0;

		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] == '|') {
					cnt++;
					dfs2(i,j);
				}
			}
		}

		answer += cnt;
		System.out.println(answer);
	}

	static void dfs1(int y, int x) {
		if (x >= M) return;
		if (map[y][x] != '-') return;
		map[y][x] = '0';
		dfs1(y, x + 1);
	}

	static void dfs2(int y, int x) {
		if (y >= N) return;
		if (map[y][x] != '|') return;
		map[y][x] = '0';
		dfs2(y+1, x );
	}
}