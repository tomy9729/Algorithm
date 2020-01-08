#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string s;
	getline(cin, s);

	string s2;
	s2.resize(s.length());
	for (int i = 0; i < s.length(); i++)
	{
		s2[i] = s[s.length() - i - 1];
	}

	string s3, s4;
	s3.resize(3);
	s4.resize(3);

	for (int i = 0; i < 3; i++)
	{
		s3[i] = s2[i];
	}
	for (int i = 4; i < 7; i++)
	{
		s4[i - 4] = s2[i];
	}

	int a, b;
	a = atoi(s3.c_str());
	b = atoi(s4.c_str());

	if (a > b)cout << a;
	else cout << b;

	return 0;
}