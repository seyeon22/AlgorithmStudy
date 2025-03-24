import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int index;
        int value;
        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max <= num) {
                max = num;
                answer[i] = 0;
            } else if (s.peek().value >= num) {
                answer[i] = s.peek().index;
            } else {
                while (s.peek().value < num) {
                    s.pop();
                }
                answer[i] = s.peek().index;
            }
            s.push(new Pair(i+1, num));
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}