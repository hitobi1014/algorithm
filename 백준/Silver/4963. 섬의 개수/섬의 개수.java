import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int[] dy = {-1,1,0,0,-1,1,-1,1};
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int W,H;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) break;
			map = new int[H][W];
			int answer = 0;

			// input
			for (int i=0; i<H; i++){
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 로직
			for (int i=0; i<H; i++) {
				for (int j=0; j<W;j++){
					if (map[i][j] == 1) {
						answer++;
						dfs(i,j);
					}
				}
			}

			sb.append(answer).append('\n');
		}

		System.out.println(sb.toString());


	}

	static void dfs(int y, int x) {
		map[y][x] = -1;

		for (int i=0; i<8; i++) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];

			if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W || map[nextY][nextX] != 1) continue;
			dfs(nextY, nextX);
		}

	}
}