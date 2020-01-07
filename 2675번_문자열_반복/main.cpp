#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t;
	cin >> t;

	int *r = new int[t];
	string *s = new string[t];
	string *p = new string[t];

	for (int i = 0; i < t; i++)
	{
		cin >> r[i];
		cin >> s[i];

		p[i].resize(r[i] * s[i].size());

		for (int j = 0; j < p[i].size(); j+=r[i])
		{
			for (int k = j; k < j + r[i]; k++)
			{
				p[i][k] = s[i].at(j / r[i]);
			}
		}
	}
	for (int i = 0; i < t; i++)
	cout << p[i]<<"\n";
	return 0;
}