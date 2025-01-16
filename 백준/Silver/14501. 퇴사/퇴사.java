import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n+1];
        int[] pay = new int[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int[] sum = new int[n+2];

        for (int i = n; i > 0; i--) {
            if (i + time[i] > n+1) {
                sum[i] += sum[i+1];  // 여기 수정
                continue;  // 퇴사 날짜 뒤면 pass
            }

            sum[i] += Math.max(sum[i+1], pay[i] + sum[i+time[i]]);
            if (max < sum[i]) {
                max = sum[i];
            }
        }

        System.out.println(max);
    }
}