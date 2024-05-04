import java.util.*;
import java.io.*;

public class Main {
    static String N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();
        M = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < N.length(); i++) {
            leftStack.push(N.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            switch (cmd) {
                case 'P':
                    leftStack.push(command.charAt(2));
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.empty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                default:
                    break;
            }

        }
        while (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.empty()) {
            bw.write(rightStack.pop());
        }
        bw.close();
        br.close();

    }
}