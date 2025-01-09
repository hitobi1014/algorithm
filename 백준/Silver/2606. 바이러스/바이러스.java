import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      List[] list = new List[N+1];
      int[] answer = new int[N+1];
      for (int i=1; i<=N; i++) {
          list[i] = new ArrayList<Integer>();
          answer[i] = 1;
      }
      
      int n = Integer.parseInt(br.readLine());
      
      for (int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int prev = Integer.parseInt(st.nextToken());
          int next = Integer.parseInt(st.nextToken());
          
          list[prev].add(next);
          list[next].add(prev);
      }
      
      answer[1] = 0;
      
      Queue<Integer> q = new LinkedList<>();
      
      q.offer(1);
      int cnt = 0;
      
      while (!q.isEmpty()) {
          int cur = q.poll();
          
          for (int i=0; i<list[cur].size(); i++) {
              int x = (Integer) list[cur].get(i);
              if (answer[x] == 0) continue;
              q.offer(x);
              cnt++;
              answer[x] = 0;
          }
      }
      
      System.out.println(cnt);
  }
}