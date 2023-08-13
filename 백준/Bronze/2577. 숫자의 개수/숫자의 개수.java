import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put(i, 0);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int multiply = a * b * c;

        String str = String.valueOf(multiply);
        for (char x : str.toCharArray()) {
            int num = x - '0';
            map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}