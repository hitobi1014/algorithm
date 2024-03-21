import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String key = br.readLine();
		int answer = 0;
		int startIdx = 0;

		while(startIdx+key.length() <= input.length()) {
			String contain = input.substring(startIdx, startIdx + key.length());

			if (contain.equals(key)) {
				answer++;
				startIdx += key.length();
			} else {
				startIdx++;
			}
		}
		System.out.println(answer);
	}
}