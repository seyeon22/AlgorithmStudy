import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];

        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            long[] p = new long[num[i]+3];
            p[1] = 1;
            p[2] = 1;
            p[3] = 1;
            if (num[i] <= 3) {
                System.out.println(p[num[i]]);
                continue;
            }
            for (int j =4 ; j <= num[i]; j++) {
                p[j] = p[j-2] + p[j-3];
            }
            System.out.println(p[num[i]]);
        }
    }
}