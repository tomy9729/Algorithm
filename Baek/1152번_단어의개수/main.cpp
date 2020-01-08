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
	int count = 0;
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == 32)count++;
	}

	count++;
	if (s[0] == 32)count--;
	if (s[s.length() - 1] == 32)count--;

	cout << count;
	return 0;
}