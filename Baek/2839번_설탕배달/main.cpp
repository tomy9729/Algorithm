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

	int r = 2147483647;
	int f, t;
	f = 0, t = 0;

	for (f = 0; 5 * f <= n; f++)
	{
		for (t = 0; 3 * t <= n; t++)
		{
			if ((f * 5 + t * 3) == n)
			{
				if (r > (f + t)) r = (f + t);
			}
		}
	}

	if (r == 2147483647)cout << -1;
	else cout << r;
	return 0;
}
