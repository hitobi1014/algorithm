package programmers;

public class Main {
    public static void main(String[] args) {
        String[] keymap = {"ABCD", "BCAC"};
        String[] target = {"ABC"};

        String tt = String.valueOf(target[0].charAt(1));
        System.out.println(keymap[1].indexOf(tt));
    }

    public int[] solution(String[] keymap, String[] target) {
        int[] answer = {};

        for (int i = 0; i < target.length; i++) {
            for (char x : target[i].toCharArray()) {
                String ch = String.valueOf(x);
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < keymap.length; j++) {
                    keymap[j].indexOf(ch);


                }

            }
        }


        return answer;
    }

}
