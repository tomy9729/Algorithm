#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	int M = 0;
	cin >> N;

	int *arr = (int*)malloc(sizeof(int)*N);
	double *ar = (double*)malloc(sizeof(double)*N);

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	for (int i = 0; i < N; i++)
	{
		if (M < arr[i])M = arr[i];
	}
	for (int i = 0; i < N; i++)
	{
		ar[i] = ((double)arr[i] / (double)M) * 100.0;
	}

	double r = 0.0;

	for (int i = 0; i < N; i++)
	{
		r = r + ar[i];
	}

	cout << (double)r / (double)N << "\n";

	return 0;
}