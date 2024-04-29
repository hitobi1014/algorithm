import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String answer = "";
        
        if (n%2==0) {
            answer = n + " is even";
        } else {
            answer = n + " is odd";
        }
        System.out.println(answer);
    }
}