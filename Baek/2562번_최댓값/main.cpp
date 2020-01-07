#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	//int a;
	//cin >> a;

	//int *b = (int*)malloc(sizeof(int)*a);

	int b[9];
	for (int i = 0; i < 9; i++)
	{
		cin >> b[i];
	}
	int temp = 0;
	int j;
	for (int i = 0; i < 9; i++)if (temp < b[i])
	{
		temp = b[i];
		j = i;
	}
	cout << temp << "\n" << j + 1;

	return 0;
}