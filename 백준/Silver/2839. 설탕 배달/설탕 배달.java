import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int aCount=0, bCount=0, remain = 0;
		int answer = 0;
		aCount = N/5;
		remain = N%5;

		while(remain <= N) {
			if (remain%3 == 0) {
				bCount = remain/3;
				remain %= 3;
				break;
			} else {
				aCount--;
				remain += 5;
			}
		}
		answer = aCount + bCount;
		if (remain>N || remain != 0) answer = -1;

		System.out.println(answer);
	}
}