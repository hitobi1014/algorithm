import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        // ex) [93, 30, 55]	[1, 30, 5]	[2, 1] => 
        // progress.... 
        // 배포 하루에 한 번 .. 뒤에 작업이 끝나도 앞에 작업이 끝나야 배포가 가능함
        final int COMPLETE = 100;
        int[] schedule = new int[progresses.length];
//        int max = Integer.MIN_VALUE;
        int cnt = 0;
        
        for (int i=0; i<progresses.length; i++) {
        	int remainTask = COMPLETE - progresses[i]; // 남은 작업
        	schedule[i] = (int) Math.ceil( (double) remainTask/speeds[i] );
        	queue.add(schedule[i]);
        	
        	// 현재값을 첫번째 값과 비교 
        	// -> 같거나 작으면 cnt++ 
        	// -> 크면 카운트 리셋
        	if (schedule[i] <= queue.peek()) {
        		cnt++;
        	} else {
        		// answer에 cnt 추가 후 1로 리셋
        		list.add(cnt);
        		cnt = 1;
        		// 현재 들어와있는 큐 크기 -1 만큼 꺼내기
        		for (int j=0, size = queue.size()-1; j<size; j++) {
        			queue.poll();
        		}
        	}
        	// 남은 작업량?일수? 새로운 배열에 담기
        	
        }
        
        if (queue.size() > 0 ) {
        	list.add(cnt);
        }
        
        answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}