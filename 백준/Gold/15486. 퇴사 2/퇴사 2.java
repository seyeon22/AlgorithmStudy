import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        long[] dp = new long[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        if (t[n] + n > n+1) dp[n] = 0;
        else dp[n] = p[n];

        for (int i = n-1; i >= 1; i--) {
            if (i + t[i] - 1 > n) {
                dp[i] = dp[i+1];
                continue;
            }
            else if (i+t[i]-1 == n) {
                dp[i] = p[i];
                if (dp[i+1] > dp[i]) dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.max(dp[i+t[i]] + p[i], dp[i+1]);
        }

        System.out.println(dp[1]);
    }
}