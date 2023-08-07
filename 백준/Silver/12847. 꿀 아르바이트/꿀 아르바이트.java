import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long max = Integer.MIN_VALUE;
    static long[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rent = Integer.parseInt(st.nextToken());
        int workAble = Integer.parseInt(st.nextToken());

        arr = new long[rent + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (long) arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < arr.length - workAble + 1; i++) {
            max = Math.max(max, arr[i + workAble - 1] - arr[i - 1]);
        }
        System.out.println(max);

    }



}