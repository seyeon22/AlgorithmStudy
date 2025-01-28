import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n+1];

        fibo[0] = 0;
        if (n == 0) {
            System.out.println(fibo[0]);
            return;
        }
        fibo[1] = 1;
        if (n == 1) {
            System.out.println(fibo[1]);
            return;
        }
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(fibo[n]);
    }
}