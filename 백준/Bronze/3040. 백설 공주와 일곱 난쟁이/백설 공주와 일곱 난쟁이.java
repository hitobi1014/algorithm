import java.io.FileInputStream;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        solution(arr, sum);
    }

    static void solution(int[] arr, int sum) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int diff = arr[i] + arr[j];
                if (sum - diff == 100) {
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] != arr[i] && arr[k] != arr[j]) {
                            sb.append(arr[k]).append('\n');
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }

}