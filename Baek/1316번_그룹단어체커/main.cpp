#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int group_word(string s);
int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);


	int l = 0;
	int n;
	cin >> n;

	string *s = new string[n];

	for (int i = 0; i < n; i++)
	{
		cin >> s[i];
	}

	for (int i = 0; i < n; i++)
	{
		l += group_word(s[i]);
	}

	cout << l;


	return 0;
}

int group_word(string s)
{
	int alp[26] = { 0, };
	for (int i = 0; i < s.length(); i++)
	{
		if (alp[s[i] - 97] == 0)
		{
			if (s[i] != s[i + 1])
			{
				alp[s[i] - 97] = 1;
			}
		}
		else
		{
			return 0;
		}
	}
	return 1;
}