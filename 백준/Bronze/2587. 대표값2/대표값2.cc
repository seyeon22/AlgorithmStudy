#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int arr[5];
    int avg = 0;
    
    for (int i = 0; i < 5; i++) cin >> arr[i];
    for (int i = 0; i < 5; i++) avg += arr[i];
    sort(arr, arr+5);
    cout << avg/5 << '\n';
    cout << arr[2];
    return 0;
}