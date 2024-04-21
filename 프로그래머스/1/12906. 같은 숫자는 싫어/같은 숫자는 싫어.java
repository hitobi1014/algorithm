import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i=1; i<arr.length;i++){
            if (stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }
        
        answer = stack.stream()
            .mapToInt(n->n)
            .toArray();

        return answer;
    }
}