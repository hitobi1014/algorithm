import java.util.Scanner;
public class Main {
    // 백준허브
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String search = sc.nextLine();

        System.out.println(solution(str,search));
    }

    public static int solution(String str, String search) {
        int answer = 0;
        int startIdx = 0;
        int searchLength = search.length();

        while (startIdx < str.length()) {
            int idx = str.indexOf(search, startIdx);
            if (idx == -1) break;
            answer++;
            startIdx = searchLength + idx;
        }

        return answer;
    }
}
