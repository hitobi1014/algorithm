package 인프런.section1;

import java.util.Scanner;

/**
 * 2022.05.23 대소문자 변환
 * 설명 :
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 * 입력 :
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력 :
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */
public class ConvertString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열을 입력하세요 100자 이하");
        String str = sc.nextLine(); // 입력받을 문자열

        ConvertString conStr = new ConvertString();
        StringBuffer ret = conStr.solution(str);
        System.out.println(ret);

    }

    public StringBuffer solution(String str){
        StringBuffer sb = new StringBuffer();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {          // 문자가 대문자면
                sb.append(Character.toLowerCase(c));
//                ret += Character.toLowerCase(c);        // 문자를 소문자로 변환 후 ret에 +
            } else if (Character.isLowerCase(c)) {  // 문자가 소문자면
                sb.append(Character.toUpperCase(c));
//                ret += Character.toUpperCase(c);        // 문자를 대문자로 변환 후 ret에 +
            }
        }
//        String ret = sb.toString();
        // 아스키문자로도 비교 가능
        // 대문자 : 65~90 소문자 : 97~122
//        for (char c : str.toCharArray()) {
//            if (c >= 97 && c<= 122) {   // 문자가 소문자이면
//                ret += (char)(c-32);
//            } else {                    // 문자가 대문자이면
//                ret += (char)(c+32);
//            }
//        }

        return sb;
    }

}
