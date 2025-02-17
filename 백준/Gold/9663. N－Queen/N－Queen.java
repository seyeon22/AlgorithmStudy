import java.io.*;

public class Main {
    static int n;
    static int cnt;
    static boolean[] visit1;
    static boolean[] visit2;
    static boolean[] visit3;

    public static void backTracking(int a) {
        if (a == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit1[i] || visit2[a+i] || visit3[a-i+n-1]) continue;
            visit1[i] = true;
            visit2[a+i] = true;
            visit3[a-i+n-1] = true;
            backTracking(a+1);
            visit1[i] = false;
            visit2[a+i] = false;
            visit3[a-i+n-1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit1 = new boolean[n];
        visit2 = new boolean[n*2];
        visit3 = new boolean[n*2];

        backTracking(0);

        System.out.println(cnt);
    }
}