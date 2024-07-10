#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int arr[7];
    int sum = 0;
    int min = 100;
    int y = false;
    for (int i = 0; i < 7; i++) cin >> arr[i];
    for (int i = 0; i < 7; i++) {
        if (arr[i]%2 == 1) {
            sum += arr[i];
            if (min > arr[i]) min = arr[i];
            y = true;
        }
    }
    if (y) cout << sum << '\n' << min;
    else cout << "-1";
    return 0;
}