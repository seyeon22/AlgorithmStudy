import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(ch[0]);

        int ans = 0;
        boolean flag = false;
        for (int i = 1; i < ch.length; i++) {
            if (!stack.isEmpty() && stack.peek() != ch[i]) {
                stack.pop();
                if (!flag) {
                    ans += stack.size();
                    flag = true;
                } else ans++;
            } else {
                stack.push(ch[i]);
                flag = false;
            }
        }
        System.out.println(ans);
    }
}