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

	string s;
	cin >> s;
	s.resize(n);

	int r = 0;
	for (int i = 0; i < n; i++)
	{
		r += s.at(i) - '0';
	}

	cout << r;

	return 0;
}