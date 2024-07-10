#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int card[20] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 };
    for (int i = 0; i < 10; i++) {
        int a, b;
        cin >> a >> b;
        vector<int> v(a - 1);
        for (int j = a - 1; j < b; j++) v.push_back(card[j]);
        reverse(v.begin()+a-1, v.end());
        for (int j = a - 1; j < b; j++) card[j] = v[j];
    }
    for (int i = 0; i < 20; i++) cout << card[i] << ' ';

    return 0;
}