#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    long long a = 0, b = 0;
    int cnt = 0;
    long long list = 0;
    cin >> a >> b;
    if (a > b)
        swap(a, b);
    if (a==b || b-1 ==1) cout << 0;
    else {
        cnt = b - a - 1;
        cout << cnt << '\n';
        for (long long i = 1; i < b-a; i++)
            cout << a+i << ' ';
    }
    return 0;
}