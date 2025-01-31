import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        if (s + v[1] <= m) {
            dp[1][s + v[1]] = s + v[1];
            queue.add(s + v[1]);
            visited.add(s + v[1]);
        }
        if (s - v[1] >= 0) {
            dp[1][s - v[1]] = s - v[1];
            queue.add(s - v[1]);
            visited.add(s - v[1]);
        }
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            int size = queue.size();
            int[] temp = new int[size];

            for (int j = 0; j < size; j++) {
                temp[j] = queue.poll();
            }

            for (int j : temp) {
                if (j + v[i] <= m && dp[i][j + v[i]] == -1) {
                    dp[i][j + v[i]] = j + v[i];
                    queue.add(j + v[i]);
                }
                if (j - v[i] >= 0 && dp[i][j - v[i]] == -1) {
                    dp[i][j - v[i]] = j - v[i];
                    queue.add(j - v[i]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i] > max) max = dp[n][i];
        }
        System.out.println(max);
    }
}