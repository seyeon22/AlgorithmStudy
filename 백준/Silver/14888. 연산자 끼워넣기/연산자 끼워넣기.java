import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] operator;
    static boolean[] visited;
    static int[] output;
    static List<int[]> permutations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = new int[4];
        operator = new int[n-1];  // 연산자를 1,2,3,4로 생각하기
        visited = new boolean[n-1]; // 방문 체크
        output = new int[n-1]; // 연산자 순열 저장

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            for (int j = sum; j < sum+temp[i]; j++) {
                operator[j] = i;
            }
            sum += temp[i];
        }

        permutation(0);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int[] perm : permutations) {
            int result = calculate(perm);
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void permutation(int depth) {
        if (depth == n-1) {
            permutations.add(output.clone());  // 리스트 복사해서 순열 저장
            return;
        }

        for (int i = 0; i < n-1; i++) {
            if (visited[i] || (i > 0 && operator[i] == operator[i-1] && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            output[depth] = operator[i];
            permutation(depth+1);
            visited[i] = false;
        }
    }

    static int calculate(int[] operators) {
        int result = nums[0];  // 첫 번째 숫자부터 시작
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == 0) {
                result += nums[i+1];
            } else if (operators[i] == 1) {
                result -= nums[i+1];
            } else if (operators[i] == 2) {
                result *= nums[i+1];
            } else if (operators[i] == 3) {
                result /= nums[i+1];
            }
        }
        return result;
    }
}