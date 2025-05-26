import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void backTracking(int at, int depth) throws IOException{
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            backTracking(at+1, depth+1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[8];

        backTracking(0, 0);
        bw.flush();
    }
}