import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][];
        int[][] dp = new int[n+1][];

        for (int i = 1; i <= n; i++) {
            graph[i] = new int[n+1];
            dp[i] = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = graph[1][1];
        if (n == 1) {
            System.out.println(dp[1][1]);
            return;
        }
        dp[2][1] = dp[1][1] + graph[2][1];
        dp[2][2] = dp[1][1] + graph[2][2];
        if (n <= 2) {
            System.out.println(Math.max(dp[2][1], dp[2][2]));
            return;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1)
                    dp[i][j] = dp[i-1][j]+graph[i][j];
                else if (j == i)
                    dp[i][j] = dp[i-1][j-1]+graph[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1]+graph[i][j], dp[i-1][j]+graph[i][j]);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < dp[n][i]) max = dp[n][i];
        }
        System.out.println(max);
    }
}