import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6808. 규영이와 인영이의 카드게임
 */
public class Solution {
    // index[0] : 이기는 경우
    // index[1] : 지는경우
    private static int[] gameResult;
    private static int[] scores; // 0 player, 1 computer
    private static int[] computer = new int[9]; // 규영이 역할
    private static int[] player = new int[9]; // 인영이 카드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            gameResult = new int[2];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                computer[j] = Integer.parseInt(st.nextToken());
            }
            int[] comTemp = Arrays.copyOf(computer, computer.length);
            Arrays.sort(comTemp);

            for (int num = 1, comIdx = 0, idx=0; num <= 18; num++) {
//                if (comIdx < 9 && computer[comIdx] == num) {
                if (comIdx < 9 && comTemp[comIdx] == num) {
                    comIdx++;
                    continue;
                }
                player[idx++] = num;
            }

            // 정렬
            Arrays.sort(player);

            // 메서드 실행
            do {
                compare();
            } while (np());
            sb.append("#").append(i).append(' ').append(gameResult[1]).append(' ').append(gameResult[0]).append('\n');
        }

        System.out.println(sb.toString());

    }

    private static boolean np() {
        // 맨 뒤 부터 탐색, 꼭대기 찾기
        int top = player.length;
        int i = top - 1;
        while (i>0 && player[i-1] >= player[i]) i--;

        if (i==0) return false; // 순열이 끝났을때

        // 꼭대기 직전 위치에 교환할 한 단계 큰 수 찾기
        int j = top - 1;
        while (player[i-1] >= player[j]) j--;

        // 꼭대기 직전위치의 수와 한 단계 큰 수 교환
        swap(i - 1, j);

        // 꼭대기 자리부터 맨 뒤까지 수를 오름차순 형태로 변경
        int k = top - 1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int a, int b) {
        int temp = player[a];
        player[a] = player[b];
        player[b] = temp;
    }

    private static void compare(){
        scores = new int[2];

        for (int idx = 0; idx < 9; idx++) {
            // gameResult[0] : 인영이가 이기는 경우
            // gameResult[1] : 인영이가 지는 경우
            int com = computer[idx];
            int pl = player[idx];

            // 컴퓨터 이김 (규영)
            if (com > pl){
                scores[1] = com + pl + scores[1];
            } else { // 인영이 이김
                scores[0] = com + pl + scores[0];
            }
        }
        if (scores[1] == scores[0]) return;

        // 1번 컴퓨터, 0번 player
        if (scores[1] > scores[0]) {
            gameResult[1]++;
        } else {
            gameResult[0]++;
        }
    }
}