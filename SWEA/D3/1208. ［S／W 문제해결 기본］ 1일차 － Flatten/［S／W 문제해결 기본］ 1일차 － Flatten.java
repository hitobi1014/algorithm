import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int[] arr = new int[100];
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dumpCnt = sc.nextInt();
            for (int j = 0; j < 100; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println("#" + test_case + " " +solution(arr, dumpCnt));

		}
	}
    
    static int solution(int[] arr, int dumpCnt) {

        /*
        * dumpCnt 만큼 돌기
        * 1. 블럭의 가장 높은 층 찾기
        * 2. 블럭의 가장 낮은 층 찾기
        * 3. 옮기기
        * */


        while (dumpCnt > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int maxIdx = -1, minIdx = -1;

            for (int i = 0; i < 100; i++) {
                if (max <= arr[i]) {
                    max = Math.max(max, arr[i]);
                    maxIdx = i;
                } 
                if (min > arr[i]) {
                    min = Math.min(min, arr[i]);
                    minIdx = i;
                }
            }
            arr[maxIdx]--;
            arr[minIdx]++;
            dumpCnt--;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return max-min;
    }
}