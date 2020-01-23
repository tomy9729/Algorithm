#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;

	int count = 0;
	int r = 0;

	while (r < n)
	{
		r += count;
		count++;
	}
	r -= count;

	if (count % 2)
	{

		int i = n - r;

		cout << i - 1 << "/" << count - (i)+1;
	}
	else
	{
		int i = n - r;

		cout << count - (i)+1 << "/" << i - 1;
	}


	return 0;
}
