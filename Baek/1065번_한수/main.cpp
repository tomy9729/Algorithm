#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int a(int n);
int b(int n);
int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;
	cout << b(n);

	return 0;
}

int a(int n)
{
	int count = 0;

	int m = n;

	while (n)
	{
		count++;
		n = n / 10;
	}
	int *b = new int[count];
	memset(b, 0, sizeof(b));

	count = 0;
	while (m)
	{
		b[count] = m % 10;
		m = m / 10;
		count++;
	}

	int i;

	if (count == 1)return 1;
	else if (count == 2)return 1;
	else
	{
		for (i = 0; i < count - 2; i++)
		{
			if ((b[i] - b[i + 1]) == (b[i + 1] - b[i + 2]));
			else return 0;
		}
		return 1;
	}
}

int b(int n)
{
	int i = 0;
	int count = 0;

	for (i = 1; i <= n; i++)
	{
		count += a(i);
	}
	return count;
}