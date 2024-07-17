#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N = 0;

    cin >> N;
    int big = 0, max_idx = 0;
    int arr[10] = {0, };

    while (N > 0) {
        arr[N % 10]++;
        N /= 10;
    }
    
    for (int i = 0; i < 10; i++) {
        if (i == 6 || i == 9) continue;
        big = max(big, arr[i]);
    }
    big = max(big, (arr[6] + arr[9] + 1) / 2);
    cout << big;
    return 0;
}