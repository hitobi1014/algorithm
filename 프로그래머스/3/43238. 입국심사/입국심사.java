import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long max = (long) times[times.length-1] * n;
        long min = 1;
        long sum;
        answer = max;
        
        while (min <= max) {
            sum = 0;
            long mid = (min + max)/2;
            
            for (int time : times) {
                sum += mid/time;
            }
            
            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        
        return answer;
    }
}