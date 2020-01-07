#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a[26];
	memset(a, -1, sizeof(a));

	string s;
	cin >> s;

	for (int i = 0; i < s.length(); i++)
	{
		if (a[s.at(i) - 97] == -1)
			a[s.at(i) - 97] = i;
	}

	for (int i = 0; i < 26; i++)
	{
		cout << a[i] << " ";
	}
	return 0;
}