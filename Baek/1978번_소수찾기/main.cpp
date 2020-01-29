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

	int N;

	cin >> N;

	int *num = new int[N];

	int count = 0;
	int r = 0;
	for (int i = 0; i < N; i++)
	{
		r = 0;
		cin >> num[i];

		if (num[i] == 1)continue;
		for (int j = 2; j < num[i]; j++)
		{
			if (!(num[i] % j))r++;
		}
		if (!r)count++;
	}
	cout << count << "\n";

	return 0;
}