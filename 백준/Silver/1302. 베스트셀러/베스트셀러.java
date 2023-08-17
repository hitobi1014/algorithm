import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 팔린 개수
        Map<String, Integer> salesBook = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            salesBook.put(str, salesBook.getOrDefault(str, 0) + 1);
        }

        Map.Entry<String, Integer> entry = Collections.max(salesBook.entrySet(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        System.out.println(entry.getKey());
    }

}