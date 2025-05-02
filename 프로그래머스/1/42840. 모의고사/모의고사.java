import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int size = answers.length;  // 정답의 길이

        int[] one = new int[size];
        int[] two = new int[size];
        int[] three = new int[size];
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;

        for (int i = 0 ; i < size; i++) {  // 수포자들의 답 대입
            if ((i+1)%5 == 0) {
                one[i] = first[4];
            } else {
                one[i] = first[(i+1)%5 - 1];
            }
            if ((i+1)%8 == 0) {
                two[i] = second[7];
            } else {
                two[i] = second[(i+1)%8 - 1];
            }
            if ((i+1)%10 == 0) {
                three[i] = third[9];
            } else {
                three[i] = third[(i+1)%10 - 1];
            }

            if (one[i] == answers[i]) ans1++;
            if (two[i] == answers[i]) ans2++;
            if (three[i] == answers[i]) ans3++;
        }

        int mx = 0;
        mx = Math.max(ans1, ans2);
        mx = Math.max(mx, ans3);

        int j = 0;
        int[] temp = new int[3];
        if (ans1 == mx) temp[j++] = 1;
        if (ans2 == mx) temp[j++] = 2;
        if (ans3 == mx) temp[j++] = 3;
        int[] answer = new int[j];
        for (int i = 0; i < j; i++) {
            if (temp[i] != 0) {
                answer[i] = temp[i];
            }
        }

        return answer;
    }
}

// 문제 : 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
//           가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
// 시험 <= 10,000 / 문제의 정답은 1, 2, 3, 4, 5중 하나
// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주기

// 1번 수포자는 1, 2, 3, 4, 5가 반복
// 2번 수포자는 2, 1, 2, 3, 2, 4, 2, 5가 반복
// 3번 수포자는 3, 3, 1, 1, 2, 2, 4, 4, 5, 5가 반복
// 그러면 수포자들의 답안을 넣어놓고 비교??