import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int n;
    private static String[] lastDigit = {"1", "3", "7", "9"};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        findPrimeNum();
        System.out.println(sb.toString());
    }


    /**
     * 소수를 추출하기 위한 조건
     * 1. 왼쪽 1자리는 무조건 2,3,5,7에서 시작해야함
     * 2. 1의자리는 짝수, 5의 배수는 제외
     * 3. 1의자리는 1,3,7,9를 붙여 소수인지 판단
     * 4. 안쪽의 2중 반복문이 2자리수를 만들기때문에 가장 바깥쪽은 N-1돌아야함 
     */
    private static void findPrimeNum() {
        ArrayList<String> frontPrime = new ArrayList<>(Arrays.asList(new String[]{"2", "3", "5", "7"}));
        ArrayList<String> receivePrime;

        for (int i = 0; i < n-1; i++) {
            receivePrime = new ArrayList<>();

            for (int j = 0; j < frontPrime.size(); j++) {
                String fp = frontPrime.get(j);

                for (int k = 0; k < lastDigit.length; k++) {
                    String lp = fp + lastDigit[k];
                    if (isPrime(Integer.valueOf(lp))) {
                        receivePrime.add(lp);
                    }
                }
            }
            frontPrime = receivePrime;
        }
        frontPrime.forEach(list -> sb.append(list).append('\n'));
    }

    // n-1까지 반복을 돌면서 소수인지 판별
    private static boolean isPrime(int n) {
        for (int i = 3; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

}