import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */
public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findMaxDiff(br.readLine()));
    }

    private static int findMaxDiff(String str){
        StringTokenizer diff = new StringTokenizer(str, "-");
        int sum = 123456;

        while (diff.hasMoreTokens()) {
            int tmp = 0;
            
            StringTokenizer add = new StringTokenizer(diff.nextToken(), "+");
            while (add.hasMoreTokens()) tmp += Integer.parseInt(add.nextToken());

            if (sum == 123456) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        return sum;
    }
}