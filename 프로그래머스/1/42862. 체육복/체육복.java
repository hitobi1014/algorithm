import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// 도난당한 학생이 여벌옷 가지고있으면 -1로 
		A:for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					answer++;
					continue A;
				}
			}
		}
		
		// 체육복 빌려주기
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == -1 || reserve[j] == -1) continue;
				if (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1){
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
				}
			}
		}
		
		answer = n - lost.length + answer;
        return answer;
    }
}