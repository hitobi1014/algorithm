import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')') return false;

        for (char c : s.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) stack.pop();
                if (!stack.isEmpty() && stack.peek() == ')'){
                    answer = false;
                    break;
                }
                
            }
        }
        
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}