#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int arr[9] = { 0, };
    int a = 0, b = 0;
    int sum = 0, target=0, sum2 = 0;  // 키 합계 계산
    for (int i = 0; i < 9; i++)
        cin >> arr[i];
    for (int i = 0; i < 9; i++)
        sum += arr[i];
    target = sum - 100;

    sort(arr, arr + 9);

    for (int j = 0; j < 9; j++) {
        for (int k = (j + 1); k < 9; k++) {
            sum2 = 0;
            a = arr[j];
            b = arr[k];
            sum2 = arr[j] + arr[k];
            if (sum2 == target)
                break;
        }
        if (sum2 == target)
            break;
    }
    
    for (int i = 0; i < 9; i++)
        if (a != arr[i] && b != arr[i])
            cout << arr[i] << '\n';

    return 0;
}