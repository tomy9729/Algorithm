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
	int start = 1;
	while (start  < n)
	{
		start += 6 * count;
		count++;
	}
	if (n == 1)cout << 1;
	else	cout << count++;

	return 0;
}
