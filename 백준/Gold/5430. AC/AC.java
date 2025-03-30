import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            String function = br.readLine();
            char[] f = function.toCharArray();

            int n = Integer.parseInt(br.readLine());

            String arrs = br.readLine();

            if (n == 0) {
                if (function.contains("D")) {
                    bw.write("error\n");
                    continue;
                }
                bw.write("[]\n");
                continue;
            }

            arrs = arrs.substring(1, arrs.length()-1);
            String[] nums = arrs.split(",");

            Deque<Integer> dq = new LinkedList<>();
            for (String num : nums) {
                dq.offer(Integer.parseInt(num));
            }

            boolean exit = false;
            boolean cursor = false;

            for (int i = 0; i < f.length; i++) {
                if (f[i] == 'R') {
                    if (cursor) cursor = false;
                    else cursor = true;
                } else if (f[i] == 'D') {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        exit = true;
                        break;
                    }
                    if (cursor) dq.pollLast();
                    else dq.poll();
                }
            }
            if (exit) continue;

            if(dq.isEmpty()) {
                bw.write("[]\n");
                continue;
            }

            bw.write("[");
            int size = dq.size() - 1;
            if (!cursor) {
                for (int i = 0; i < size; i++) {
                    bw.write(dq.poll() + ",");
                }
            } else {
                for (int i = 0; i < size; i++) {
                    bw.write(dq.pollLast() + ",");
                }
            }
            bw.write(dq.poll() + "]\n");
        }
        bw.flush();
    }
}