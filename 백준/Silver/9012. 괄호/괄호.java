import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<T;i++){
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			String answer = "YES";
			for (char c : str.toCharArray()) {
				if (c == '(') {
					stack.add(c);
				} else {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						answer = "NO";
						break;
					}
				}
			}
			if (!stack.isEmpty()) answer = "NO";
			sb.append(answer).append('\n');
		}

		System.out.println(sb);
	}
}