#include <iostream>
#include <string>
#include <vector>
using namespace std;

int d(int n);

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	//int N;
	//cin >> N;

	//cout << d(N);

	int A[10001] = { 0, };

	for (int i = 0; i < 10001; i++)
	{
		if (d(i)<10001)A[d(i)] = 1;
	}
	for (int i = 1; i < 10001; i++)
	{
		if (!A[i])cout << i << "\n";
	}

	return 0;
}

int d(int n)
{
	int m = n;
	int temp = 0;
	while (n)
	{
		temp += n % 10;
		n = n / 10;
	}
	return (m + temp);
}