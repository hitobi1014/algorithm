import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (arr[0] != 1 && arr[0] != 8) {
            System.out.println("mixed");
        } else {
            int x = arr[0];
            if (x == 1){
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != i + 1) {
                        System.out.println("mixed");
                        return;
                    }
                }
                System.out.println("ascending");

            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] + i != arr.length) {
                        System.out.println("mixed");
                        return;
                    }
                }
                System.out.println("descending");
            }
        }
    }
}