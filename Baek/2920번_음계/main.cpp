#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int temp = 0;
	int a[8];

	for (int i = 0; i < 8; i++)cin >> a[i];

	for (int i = 0; i < 7; i++)
	{
		if (a[i] + 1 == a[i + 1])temp = 1;
		else if (a[i] - 1 == a[i + 1])temp = 2;
		else
		{
			temp = 3;
			break;
		}
	}

	if (temp == 1)printf("ascending");
	else if (temp == 2)printf("descending");
	else printf("mixed");

	return 0;
}