#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int apart(int k, int n)
{
	if (k == 0)return n;

	int r = 0;
	for (int i = 1; i <= n; i++)
	{
		r += apart(k - 1, i);
	}
	return r;
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int T;
	cin >> T;

	int k, n;

	for (int i = 0; i < T; i++)
	{
		cin >> k >> n;
		cout << apart(k, n) << endl;
	}


	return 0;
}
