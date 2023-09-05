import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * N장 1~N
 * 위에서부터 순서대로 1~N 놓여져있음
 * 위에 한장 버리고 -> 위에있는 카드 맨아래로 (1장될때까지 반복)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (deque.size() > 1) {
            // 카드 버리기
            deque.pollFirst();

            // 맨 윗카드 아래로 옮기기
            deque.offerLast(deque.pollFirst());
        }

        System.out.println(deque.poll());
    }

}