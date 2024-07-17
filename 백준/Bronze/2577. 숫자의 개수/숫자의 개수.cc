#include <iostream>
#include <string>
using namespace std;

int arr[10];
int main() {
	int a, b, c;
	cin >> a >> b >> c;
	long result = a*b*c;
	string s = to_string(result);
	for (auto e : s) {
		arr[e - '0']++;
	}
	for (int i = 0; i < 10; i++)
		cout << arr[i] << ' ';
	return 0;
}