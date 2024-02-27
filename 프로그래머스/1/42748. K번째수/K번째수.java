import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int cnt = commands.length;
		int[] answer = new int[cnt];

		for (int c = 0; c < cnt; c++) {
			int i = commands[c][0];
			int j = commands[c][1];
			int k = commands[c][2];

			int[] tmp = Arrays.stream(Arrays.copyOfRange(array, i - 1, j)).sorted().toArray();
			answer[c] = tmp[k - 1];
		}

		return answer;
    }
}