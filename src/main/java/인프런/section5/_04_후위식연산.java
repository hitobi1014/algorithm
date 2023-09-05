package 인프런.section5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _04_후위식연산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String calc = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int cal = 0;

        for (char c : calc.toCharArray()) {
            // 숫자면 push
            if (Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (c) {
                    case '+':
                        cal = a + b;
                        break;
                    case '-':
                        cal = a - b;
                        break;
                    case '*':
                        cal = a * b;
                        break;
                    case '/':
                        cal = a / b;
                        break;
                }
                // 숫자 => 문자 저장
                stack.push(cal);
            }
        }

        System.out.println(cal);
    }
}
