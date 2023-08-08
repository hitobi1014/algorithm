import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            System.out.println(solution(n, answer, 0));
        }
    }

    static int solution(int n, int answer, int sum) {
        if (sum > n)  return answer;

        if (sum == n) {
            answer++;
            return answer;
        }
        for (int i = 1; i < 4; i++) {
            answer = solution(n, answer, sum + i);
        }

        return answer;
    }

}