#include <iostream>
using namespace std;

int arr[26];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	string s;
	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		arr[s[i] - 'a']++;
	}
	for (int e : arr)
		cout << e << ' ';

	return 0;
}