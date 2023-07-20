package 인프런.section1;

import java.util.Scanner;

public class FindString {

    private static String input2;

    /**
     * 설명 :
     * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     *
     * 입력 :
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * 출력 :
     * 첫 줄에 해당 문자의 개수를 출력한다.
     */
    public static void main(String[] args) {
        FindString findString = new FindString();
        Scanner scanner = new Scanner(System.in); // 입력

        String input1 = scanner.nextLine();
        String input2 = scanner.next();

        int ret = findString.solution(input1.toUpperCase(), input2.toUpperCase());
        System.out.println("문자열에 포함되어 있는 문자 개수 : " + ret + "개");
    }

    public int solution (String str, String txt) {
        int cnt = 0;
        char tx = txt.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (tx == str.charAt(i)) {
                ++cnt;
            }
        }

        // 향상된 for문 ver
//        for (char x : str.toCharArray()) {
//            if (tx == x) cnt++;
//            System.out.println("cnt : " + cnt);
//        }
        return cnt;
    }
}
