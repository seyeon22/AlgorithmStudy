import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] com = new int[n];
        for (int i = 0; i < n; i++) {
            com[i] = i;
        }

        int r = n/2;

        List<Pair> combinations = getCombination(com, r);

        int min = 1000000;

        for (Pair p : combinations) {
            int first = 0;
            int second = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && p.selected.contains(i) && p.selected.contains(j)) {
                        first += arr[i][j];
                    }
                    if (i != j && p.remaining.contains(i) && p.remaining.contains(j)) {
                        second += arr[i][j];
                    }
                }
            }
            if (first <= second) {
                if (second - first < min) min = second - first;
            } else {
                if (first - second < min) min = first - second;
            }
        }
        System.out.println(min);
    }

    public static List<Pair> getCombination(int[] com, int r) {
        List<Pair> result = new ArrayList<>();
        comb(com, new ArrayList<>(), 0, r, result);
        return result;
    }

    public static void comb(int[] com, List<Integer> selected, int startIdx, int r, List<Pair> result) {
        if (selected.size() == r) {  // r개를 선택하면 저장
            List<Integer> remaining = new ArrayList<>();
            for (int num : com) {
                if (!selected.contains(num)) {
                    remaining.add(num);
                }
            }
            result.add(new Pair(new ArrayList<>(selected), remaining));
            return;
        }

        for (int i = startIdx; i < com.length; i++) {
            selected.add(com[i]); // 요소 추가
            comb(com, selected, i + 1, r, result);  // 다음 단계 재귀 호출
            selected.remove(selected.size() - 1);  // 원상복구 (백트래킹)
        }
    }

    static class Pair {
        List<Integer> selected;
        List<Integer> remaining;

        Pair(List<Integer> selected, List<Integer> remaining) {
            this.selected = selected;
            this.remaining = remaining;
        }
    }
}