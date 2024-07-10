#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a, b, c;
    cin >> a >> b >> c;
    if ((a == b && b != c) || (a == c && b != c)) cout << a * 100 + 1000;
    else if (b == c && a != b) cout << b * 100 + 1000;
    else if (a == b && b == c) cout << a * 1000 + 10000;
    else cout << max(a, max(b, c)) * 100;

    return 0;
}