package 인프런.section4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class _02_아나그램_해시 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

//        System.out.println(solution(str1, str2));
        System.out.println(infSolution(str1, str2));

    }

    static String solution(String str1, String str2) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }
        int n1=Integer.MIN_VALUE, n2=Integer.MIN_VALUE;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            char x = entry.getKey();
            n1 = map.get(x);
            if (map2.get(x) != null) n2 = map2.get(x);
            if (n1 != n2) answer = "NO";
        }

        return answer;
    }

    static String infSolution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }
}
