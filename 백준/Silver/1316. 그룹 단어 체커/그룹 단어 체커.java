import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 1316 - 그룹 단어 체커
 */
public class Main {
    private static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. push 전 문자가 있는지 검색 = true && 상위 문자랑 해당 문자가 다르면 ===> return false
        // 위의 경우가 아니면 전부 push
        // 위의 메서드 리턴값이 true면 answer++, 아니면 변동x

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(checkWord(str)) answer++;
        }
        System.out.println(answer);

    }

    private static boolean checkWord(String str) {
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (stack.search(x) >= 0 && !stack.empty() && stack.peek() != x) return false;
            stack.push(x);
        }

        return true;
    }

}