import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stack = new Stack<>();
		
				// 시작이 )면 바로 false return
		if (s.charAt(0) == ')') {
			answer = false;
		} else {
			for (char x : s.toCharArray()) {
				stack.push(x);
				
				if (x == ')') {
					// )없애고 ( 없애고
					stack.pop();
					if (stack.size() == 0) {
						answer = false;
					} else {
						stack.pop();
					}
				}
			}
			
			if (stack.size() != 0) answer = false; 
		}
        return answer;
    }
}