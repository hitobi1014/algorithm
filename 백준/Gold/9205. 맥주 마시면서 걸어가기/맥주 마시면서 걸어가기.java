import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x,y});
            }

            boolean[][] flag = new boolean[n+2][n+2];
            for(int i=0; i<n+2; i++) {
                for(int j=0; j<n+2; j++) {
                    int[] pos = list.get(i), next = list.get(j);
                    int dis = Math.abs(pos[0] - next[0]) + Math.abs(pos[1]-next[1]);

                    if(dis <= 1000) flag[i][j] =true;
                }
            }

            for(int k=0; k<n+2; k++) {
                for(int i=0; i<n+2; i++) {
                    for(int j=0; j<n+2; j++) {
                        if(flag[i][k] && flag[k][j]) {
                            flag[i][j] = true;
                        }
                    }
                }
            }
            System.out.println(flag[0][n+1] ? "happy": "sad");
        }
    }
}