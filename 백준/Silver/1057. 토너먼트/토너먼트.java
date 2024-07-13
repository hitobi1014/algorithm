import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int im = Integer.parseInt(st.nextToken());

		int answer = 0;
		while(kim != im) {
			answer++;
			kim = kim/2 + kim%2;
			im = im/2 + im%2;
		}
		System.out.println(answer);
	}


}