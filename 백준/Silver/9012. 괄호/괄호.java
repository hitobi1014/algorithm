import java.io.*;
import java.util.*;

public class Main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<tc; i++) {
            String str = br.readLine();

            if (str.charAt(0) == ')') {
                sb.append("NO").append('\n');
                continue;
            }

            Stack<Character> stack = new Stack<Character>();
            boolean flag = true;

            for (char c : str.toCharArray()) {
                if (stack.empty() && c == ')') {
                    flag = false;
                    break;
                }

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.pop() == '(') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (stack.size() > 0 || !flag) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }

        }


        System.out.println(sb);
    }
}