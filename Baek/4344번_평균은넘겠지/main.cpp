#include <iostream>
#include <string>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	double r;
	int count = 0;
	int C;
	int N;
	cin >> C;

	int **arr = new int*[C];
	for (int i = 0; i < C; i++)
	{
		r = 0;
		count = 0;
		cin >> N;
		arr[i] = new int[N];
		for (int j = 0; j < N; j++)
		{
			cin >> arr[i][j];
			r += (double)arr[i][j];
		}
		r = r / N;
		for (int j = 0; j < N; j++)
		{
			if (arr[i][j] > r)count++;
		}
		cout.setf(ios::fixed);
		cout.precision(3);
		cout << (double)count / (double)N * 100.0 << "%" << "\n";
	}



	return 0;
}