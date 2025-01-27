import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;
        steps[0] = 0;
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }
        if (n < 3) {
            for (int step : steps) {
                max += step;
            }
            System.out.println(max);
            return;
        }

        dp[1] = steps[1];
        dp[2] = steps[1] + steps[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] + steps[i]);
        }

        System.out.println(dp[n]);
    }
}