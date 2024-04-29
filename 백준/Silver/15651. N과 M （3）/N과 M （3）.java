import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		dfs(0, arr);
		System.out.println(sb);
	}

	static void dfs(int cnt, int[] arr) {
		if (cnt==M) {
			for (int num : arr){
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i=1; i<=N; i++){
			arr[cnt] = i;
			dfs(cnt+1, arr);
		}
	}


}