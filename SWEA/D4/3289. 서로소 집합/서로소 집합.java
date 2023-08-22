import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        int testCase = sToN.apply(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = sToN.apply(st.nextToken()); // n이하의 자연수
            int m = sToN.apply(st.nextToken()); // m 연산개수
            int[] arr = new int[n+1]; // 수가 1부터 시작하므로 0번인덱스 사용x
            make(arr);
//            String answer = String.valueOf("#"+i+" ");
            sb.append('#').append(i).append(' ');
            // 연산 시작
            for (int j = 0; j < m; j++) {
                // 0:union ## 1:find
                st = new StringTokenizer(br.readLine());
                int calc = sToN.apply(st.nextToken());
                int a = sToN.apply(st.nextToken());
                int b = sToN.apply(st.nextToken());

                if (calc == 0) {
                    union(a, b, arr);
                } else {
                    int num1 = find(a, arr);
                    int num2 = find(b, arr);
//                    answer = answer + String.valueOf(compare(num1, num2));
                    sb.append(compare(num1, num2));
                }
            }
//            System.out.println(answer);
            System.out.println(sb.toString());
        }
//        System.out.println(sb.toString());
    }

    private static int compare(int a, int b) {
        return a == b ? 1 : 0;
    }

    private static void make(int[] arr) {
        for (int i = 1; i < arr.length; i++) arr[i] = i;
    }

    private static void union(int a, int b, int[] arr) {
        int aRoot = find(a, arr);
        int bRoot = find(b, arr);
//        if (arr[a] == arr[b]) return;
        if (aRoot == bRoot) return;
        arr[bRoot] = aRoot;
    }

    private static int find(int x, int[] arr) {
        if (x == arr[x]) return x;
        else return arr[x] = find(arr[x], arr);
    }

}