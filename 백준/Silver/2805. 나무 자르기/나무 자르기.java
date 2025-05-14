import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] trees = new int[N];
    int maxH = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int height = Integer.parseInt(st.nextToken());
      trees[i] = height;
      maxH = Math.max(maxH, height);
    }

    System.out.println(resolve(trees, maxH, M));
  }

  static int resolve(int[] trees, int maxH, int M) {
    int answer = 0;
    int start = 0;
    int end = maxH;

    while (start <= end) {
      int mid = (start + end) / 2;
      long total = 0;

      for (int height : trees) {
        if (height > mid) {
          total += height - mid;
        }
      }

      if (total >= M) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return answer;
  }
}