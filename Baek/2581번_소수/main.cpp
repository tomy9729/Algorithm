#include <iostream>
#include <string>
#include <vector>
#include<cstring>
#include <cmath>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int M, N;

	cin >> M >> N;
	int min;
	int all = 0;
	int r = 0;
	int count = 0;
	for (int i = M; i <= N; i++)
	{
		r = 0;
		if (i == 1)continue;
		for (int j = 2; j < i; j++)
		{
			if (!(i%j))r++;
		}
		if (!r)
		{
			count++;
			all += i;
			if (count == 1)min = i;
		}
	}
	if (count == 0)cout << -1 << "\n";
	else
		cout << all << "\n" << min << "\n";

	return 0;
}