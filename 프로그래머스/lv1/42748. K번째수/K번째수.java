import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) { 
        int[] answer = new int[commands.length];
        // i~j 번
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            int[] tmpArr = new int[j - i + 1]; 
            
            for (int m = 0; m < tmpArr.length; m++) {
                tmpArr[m] = array[i-1+m];
            }
            Arrays.sort(tmpArr);
        	answer[n] = tmpArr[k-1];
        }
        
        return answer;
    }
}