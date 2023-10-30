import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] ret = new int[n];
		List<Integer> list = new ArrayList<>();
        long num=1;
        int idx=0;
		for(int x=1 ; x<=n ; x++) {
			list.add(x);
			num *= x;
		}
        k--;
        while(idx<ret.length) {
        	num /= (n--);
        	int i = (int)(k/num);
        	ret[idx++] = list.get(i);
        	list.remove(i);
        	k %= num;
        }
        return ret;
    }
}