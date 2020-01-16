#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int chrtonum(char c);

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string s;
	cin >> s;

	int o = 0;
	for (int i = 0; i < s.length(); i++)
	{
		o += (chrtonum(s[i]) + 1);
	}

	cout << o;

	return 0;
}

int chrtonum(char c)
{
	switch (c)
	{
	case 'A':
	case 'B':
	case 'C':
		return 2;
		break;
	case 'D':
	case 'E':
	case 'F':
		return 3;
		break;
	case 'G':
	case 'H':
	case 'I':
		return 4;
		break;
	case 'J':
	case 'K':
	case 'L':
		return 5;
		break;
	case 'M':
	case 'N':
	case 'O':
		return 6;
		break;
	case 'P':
	case 'Q':
	case 'R':
	case 'S':
		return 7;
		break;
	case 'T':
	case 'U':
	case 'V':
		return 8;
		break;
	case 'W':
	case 'X':
	case 'Y':
	case 'Z':
		return 9;
		break;
	}
}