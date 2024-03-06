import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= 10000; i++) {
			set.add(i);
		}

		for (int i = 1; i <= 10000; i++) {
			int num = i;
			int x = num;
			while (num != 0){
				x += num%10;
				num/=10;
			}
			set.remove(x);
		}

		StringBuilder sb = new StringBuilder();
		set.forEach(x-> sb.append(x).append('\n'));
		System.out.println(sb.toString());
	}
}