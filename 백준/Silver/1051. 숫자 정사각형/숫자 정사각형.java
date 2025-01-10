import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimension = br.readLine().split(" ");
        int n = Integer.parseInt(dimension[0]);
        int m = Integer.parseInt(dimension[1]);

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int start = 0;
        if (n <= m) start = n;
        else start = m;

        boolean done = false;

        for (int left = start ; left > 0; left--) {
            for (int i = 0; i <= n-left; i++) {
                for (int j = 0; j <= m-left; j++) {
                    if (board[i][j] == board[i+left-1][j] && board[i][j] == board[i+left-1][j+left-1]
                            && board[i][j] == board[i][j+left-1]) {
                        System.out.println(left*left);
                        done = true;
                        break;
                    }
                }
                if (done) break;
            }
            if (done) break;
        }
    }
}