package 인프런.section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_모든아나그램찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String search = sc.nextLine();

//        System.out.println(solution(word, search));
        System.out.println(infSolution(word,search));
    }

    static int infSolution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        int L = b.length() - 1;
        for (int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        int lt=0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }

    static int solution(String word, String search) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char x : search.toCharArray()) {
            map.put(x, map.getOrDefault(map.get(x), 0) + 1);
        }
        int sLeng = search.length();
        char[] words = word.toCharArray();
        int lt = 0, rt = 0;
        int cnt = 0;

        while (rt + sLeng < words.length) {
            char x = words[rt];
            map2.put(x, map2.getOrDefault(map2.get(x), 0) + 1);
            cnt++;
            if (cnt != 1 && sLeng % cnt == 0) {
                boolean flag = true;
                for (Map.Entry entry : map.entrySet()) {
                    char key = (char) entry.getKey();
                    if (entry.getValue() != map2.getOrDefault(key, 0)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
                map2.clear();
                lt++;
                rt = lt;
                cnt = 0;
            } else {
                rt++;
            }
        }

        return answer;
    }
}
