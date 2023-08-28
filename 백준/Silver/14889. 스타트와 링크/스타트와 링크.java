import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 스타트 ,링크 2개의 팀 =>
 * N: 4<=N<=20  (짝수만 주어짐)
 * N개의 줄에 S가 주어짐
 * S_{ii}는 항상 0임   1<= S_{ij} <100
 */
public class Main {
	
	static int[] arr[], teamStart, teamLink,npArr;
	static int[] target;
	static int N, score, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		// 입력
		for (int i=0; i<N;i++) {
			arr[i] = Stream.of(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		// 초기화
		teamStart = new int[arr.length/2];
		teamLink = new int[arr.length/2];
		npArr = new int[arr.length];
		answer = Integer.MAX_VALUE;
		
		// np위한 1셋팅
		for(int i=npArr.length/2; i<npArr.length;i++) {
			npArr[i] = 1;
		}
		
		
		Consumer<Integer> init = n-> {
			target = new int[n];
			score = 0;
		};
		
		// NP
		do {
			// npArr이 1인애들은 start팀 0은 link팀
			int sc=0, lc=0;
			for (int i=0; i<npArr.length;i++) {
				if (npArr[i]==1) {
					teamStart[sc++] = i;
				} else {
					teamLink[lc++] = i;
				}
			}
			int start =0,link=0;
			
			init.accept(2);
			combination(0, 0, teamStart);
			start=score;
			
			init.accept(2);
			combination(0, 0, teamLink);
			link=score;
			
			answer = Math.min(answer, Math.abs(start-link));
		} while(np(npArr));
		
		System.out.println(answer);
	}
	
	private static boolean np(int[] p) {
		int N = p.length;
		int i = N-1;
		// 꼭대기 찾기
		while(i>0 && p[i-1] >= p[i]) i--;
		
		// 꼭대기가 0인덱스면 return
		if (i==0) return false;
		
		// 꼭대기 직전위치(i-1)와 교환할 한 단계큰수 찾기
		int j= N-1;
		while(p[i-1] >= p[j]) j--;
		
		// swap -> 꼭대기 직전위치와 한단계 큰수 교환
		swap(p, i-1, j);
		
		// 꼭대기 자리부터 맨 뒤까지 오름차순으로 변경
		int k=N-1;
		while(i<k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] np, int a, int b) {
		int tmp = np[a];
		np[a] = np[b];
		np[b] = tmp;
	}
	
	
	private static void combination(int cnt, int start, int[] inputArr) {
		if (cnt == 2) {
			int a = target[0];
			int b = target[1];
			score += arr[a][b] + arr[b][a];
			return;
		}
		
		for (int i=start; i<inputArr.length;i++) {
			target[cnt] = inputArr[i];
			combination(cnt + 1, i+1, inputArr);
		}
	}
	
}