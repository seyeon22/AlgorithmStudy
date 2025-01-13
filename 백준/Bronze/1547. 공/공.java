import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] balls = {1,2,3};

        for (int i = 0; i < n; i++) {
            String[] dimension = br.readLine().split(" ");
            int ex1 = Integer.parseInt(dimension[0]);
            int ex2 = Integer.parseInt(dimension[1]);

            int tmp1 = 0;
            int tmp2 = 0;
            for (int j = 0; j < 3; j++) {

                if (balls[j] == ex1) {
                    tmp1 = j;
                }
                if (balls[j] == ex2) {
                    tmp2 = j;
                }
            }
            balls[tmp1] = ex2;
            balls[tmp2] = ex1;
        }
        System.out.println(balls[0]);
    }
}
