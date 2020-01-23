#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int T;
	cin >> T;

	int H, W, N;

	for (int i = 0; i < T; i++)
	{
		cin >> H >> W >> N;
		int x, y;


		if (N%H)
		{
			y = N % H;
			x = N / H + 1;
		}
		else
		{
			y = H;
			x = N / H;
		}

		if (x < 10)
			cout << y << 0 << x << endl;
		else
			cout << y << x << endl;
	}


	return 0;
}
