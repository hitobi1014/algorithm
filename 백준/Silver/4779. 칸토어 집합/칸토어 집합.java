import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static char[] cArr;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            N = Integer.parseInt(str);
            int size = (int) (Math.pow(3, N));
            cArr = new char[size];
            for (int i = 0; i < size; i++) {
                cArr[i] = '-';
            }
            cantor(0, size);

            answer.append(String.valueOf(cArr)).append('\n');
        }

        System.out.println(answer.toString());
    }

    private static void cantor(int start, int size) {
        if (size < 3) {
            return;
        }
        // 중앙 왼쪽부분은 0~str길이/3
        // 중앙 str길이/3~ str길이/2*3
        // 중앙 오른쪽부분은 str길이/2*3 ~ str길이
        int midStart = start + (size / 3);
        int midEnd = start + (size / 3 * 2);
        int modiSize = size / 3;

        for (int i = midStart; i < midEnd; i++) {
            cArr[i] = ' ';
        }
        // 왼쪽부분
        cantor(start, modiSize);
        // 오른쪽부분
        cantor(midEnd, modiSize);
    }

}