import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int A,B, answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (true){
            if (A>=B) break;

             if (B%10 == 1) {
                B /= 10;
                cnt++;
                continue;
             } else if( B%2==0) {
                 B /= 2;
                 cnt++;
                 continue;
             } else {
                 answer = -1;
                 break;
             }
        }
        if (B < A || answer == -1) {
            answer = -1;
        } else {
            answer = cnt + 1;
        }

        System.out.println(answer);
    }
}