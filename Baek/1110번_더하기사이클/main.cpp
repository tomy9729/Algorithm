#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a;
	cin >> a;
	int b, c, d;
	int temp = a;
	int count = 0;
	while (1)
	{

		if (temp < 10)
		{
			b = 0; c = temp;
		}
		else
		{
			b = temp / 10;
			c = temp % 10;
		}

		d = (b + c) % 10;

		temp = 10 * c + d;

		count++;
		if (temp == a)break;
	}

	cout << count << "\n";

	return 0;
}