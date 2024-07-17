#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	vector<int> v;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	int x;
	cin >> x;
	sort(v.begin(), v.end());

	int left = 0;
	int right = n - 1;
	while (1) {
		if (v[left] + v[right] == x) {
			ans++;
			left++;
			right--;
		}
		else if (v[left] + v[right] > x) {
			right--;
		}
		else {
			left++;
		}
		if (left >= right) break;
	}
	cout << ans;
	return 0;
}