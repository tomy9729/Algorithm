#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, x;
	cin >> N >> x;

	for (int i = 0; i < N; i++)
	{
		int t;
		cin >> t;
		if (t < x)cout << t << " ";
	}

	return 0;
}