import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int n = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            map.put(i, 0);
        }

        while (n <= 10000) {
            int num=0;
            for (char x : String.valueOf(n).toCharArray()) {
                num += Character.getNumericValue(x);
            }
            num += n;
            if (num <= 10000) map.put(num, map.get(num) + 1);
            n++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
            }
        }

    }

}
