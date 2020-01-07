#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a;
	cin >> a;

	int *b = (int*)malloc(sizeof(int)*a);

	for (int i = 0; i < a; i++)
	{
		cin >> b[i];
	}

	int c = -1000000, d = 1000000;

	for (int i = 0; i < a; i++)if (c < b[i])c = b[i];
	for (int i = 0; i < a; i++)if (d > b[i])d = b[i];

	cout << d << " " << c;


	return 0;
}