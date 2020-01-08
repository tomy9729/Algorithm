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

	int alphabet[26] = { 0, };

	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] >= 97)s[i] -= 32;
		alphabet[s[i] - 65]++;
	}

	int max = 0;
	int t;
	for (int i = 0; i < 26; i++)
	{
		if (max < alphabet[i])
		{
			max = alphabet[i];
			t = i;
		}
	}

	int count = 0;
	for (int i = 0; i < 26; i++)
	{
		if (max == alphabet[i])count++;
	}

	if (count == 1)
	{
		char temp = t + 65;
		cout << temp << "\n";
	}
	else cout << "?" << "\n";

	return 0;
}
//이거 제출해야함