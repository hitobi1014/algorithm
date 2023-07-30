import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        System.out.println(solution(N, time));
    }

    static int solution(int N, int[] time){
        int answer = 0;
        int sum = 0;
        int minTime = Integer.MAX_VALUE;
        Arrays.sort(time);
        sum = time[0];

        for (int i = 1; i < time.length; i++) {
            answer += sum;
            sum += time[i];
        }
        answer += sum;

        return answer;
    }

}
