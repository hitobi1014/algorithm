import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;


public class Main {
    static int A,B, V;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> sToNum = Integer::parseInt;

        A = sToNum.apply(st.nextToken());
        B = sToNum.apply(st.nextToken());
        V = sToNum.apply(st.nextToken());

        findDays();
    }

    private static void findDays() {
        if (A >= V) {
            System.out.println(1);
            return;
        }

        boolean condition = (V - A) % (A - B) == 0;
        int res = (V - A) / (A - B);
        if (condition) {
            System.out.println(res + 1);
        } else {
            System.out.println(res + 2);
        }
    }
}