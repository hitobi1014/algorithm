import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ( !(str = br.readLine()).equals("0")) {
            String reverse = new StringBuffer(str).reverse().toString();
            if (str.equals(reverse)) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}