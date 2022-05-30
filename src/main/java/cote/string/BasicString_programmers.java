package src.main.java.cote.string;

import java.util.Scanner;

/**
 * 2022.05.29
 *
 * 문제 설명
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 *
 * 제한 사항
 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 *
 *  입출력          예
 *  #str	     #return
 * "a234"	      false
 * "1234"	      true
 */
public class BasicString_programmers {

    public static void main(String[] args) {
        BasicString_programmers T = new BasicString_programmers();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));

    }

    public Boolean solution(String str) {
        if (str.length() == 6 || str.length() == 4) {
            for (char x : str.toCharArray()) {
                if (!Character.isDigit(x)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
