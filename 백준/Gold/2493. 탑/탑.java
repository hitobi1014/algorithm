import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * B2493_탑_최민준
 */
public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    static int N;

    static Map<Character, Integer> checkMap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i + 1); // 입력값 key, value => 1~N까지
        }
        solution(arr);
    }

    static void solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            while (!stack.isEmpty()) {
                if (stack.peek() > x) {
                    answer[i] = map.get(stack.peek());
                    break;
                }
                if (stack.peek() < x) {
                    stack.pop();
                }
            }
            stack.push(x);
        }
        
        for (int x : answer) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }


}