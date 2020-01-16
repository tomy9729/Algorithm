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
	cin >> s;

	int l = s.length();


	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == 'l' && s[i + 1] == 'j')l--;
		else if (s[i] == 'n' && s[i + 1] == 'j')l--;
		else if (s[i] == 'c' && s[i + 1] == '=')l--;
		else if (s[i] == 'c' && s[i + 1] == '-')l--;
		else if (s[i] == 'd' && s[i + 1] == '-')l--;
		else if (s[i] == 's' && s[i + 1] == '=')l--;
		else if (s[i] == 'z' && s[i + 1] == '=')l--;
	}
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == 'd' && s[i + 1] == 'z' && s[i + 2] == '=')l--;
	}

	cout << l << endl;
	return 0;
}