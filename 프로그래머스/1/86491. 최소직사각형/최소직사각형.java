import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            sizes[i][0] = Math.max(w, h);
            sizes[i][1] = Math.min(w, h);
        }
        int wMax  = 0;
        int hMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            wMax = Math.max(wMax, sizes[i][0]);
            hMax = Math.max(hMax, sizes[i][1]);
        }
        
        answer = wMax*hMax;
        
        return answer;
    }
}

// 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 함.
// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return하도록 solution 함수를 완성해라.
// 1 <= size <= 10,000, size의 원소 : [w, h] 형식 / w = 명함의 가로 길이 / h = 명함의 세로 길이
// 1 <= w와 h <= 1,000

// 그냥 가장 큰 w와 가장 큰 h를 골라서 Math.max 쓰면 될듯, 곱하면 끝?
// 아니다 둘 중에 큰거를 앞으로 하고, 작은거를 뒤로 해서 거기서 가장 큰걸 하면 될듯 