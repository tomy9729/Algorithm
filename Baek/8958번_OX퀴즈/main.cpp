#include <iostream>
#include <string>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int p = 0;
	int point = 0;
	int N;
	cin >> N;

	string* arr = new string[N];

	for (int i = 0; i < N; i++)
	{
		arr[i].resize(80);
		cin >> arr[i];
	}

	for (int i = 0; i < N; i++)
	{
		p = 0;
		point = 0;
		for (int j = 0; j < arr[i].length(); j++)
		{
			if (arr[i][j] == 'O')
			{
				p++;
				point += p;
			}
			else
			{
				p = 0;
			}
		}
		cout << point << "\n";
	}

	return 0;
}