#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	long long A, B, C;

	cin >> A >> B >> C;

	if (B >= C)
	{
		cout << -1;
		return 0;
	}
	long long count = 0;

	count = A / (C - B) + 1;
	cout << count;
	return 0;
}
