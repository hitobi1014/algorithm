package again.ch01_string;

import java.util.Scanner;

/**
 * Description
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 *
 * Input
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * Output
 * 첫 줄에 해당 문자의 개수를 출력한다.
 *
 * Example
 * Input.
 * > Computercooler
 * > c
 *
 * Output.
 * > 2
 */
public class Q1_findWord {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in); // 입력받을 객체
        System.out.println("문자열을 입력하세요");
        String inputString = sc.nextLine();

        System.out.println("찾을 문자를 입력하세요");
        char inputWord = sc.next().charAt(0);

        for (char x : inputString.toCharArray()) { // String > char 배열로 변환
            if (Character.toUpperCase(inputWord) == Character.toUpperCase(x)) {
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
