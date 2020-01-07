#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int arr[10] = { 0, };
	int a, b, c;

	cin >> a >> b >> c;

	int r = a * b * c;


	while (r)
	{
		arr[r % 10]++;

		r = r / 10;
	}

	for (int i = 0; i < 10; i++)cout << arr[i] << "\n";

	return 0;
}