import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t+1];
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            long[][] fi = new long[num[i]+2][2];
            fi[0][0] = 1;
            fi[0][1] = 0;
            fi[1][0] = 0;
            fi[1][1] = 1;
            if (num[i] <= 1) {
                System.out.println(fi[num[i]][0] + " " + fi[num[i]][1]);
                continue;
            }
            for (int j = 2; j <= num[i]; j++) {
                fi[j][0] = fi[j-1][0] + fi[j-2][0];
                fi[j][1] = fi[j-1][1] + fi[j-2][1];
            }
            System.out.println(fi[num[i]][0] + " " + fi[num[i]][1]);
        }
    }
}