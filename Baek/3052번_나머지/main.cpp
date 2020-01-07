#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);


	int ar[42] = { 0, };
	int arr[10] = { 0, };
	int count = 0;

	for (int i = 0; i < 10; i++)
	{
		cin >> arr[i];
		arr[i] = arr[i] % 42;
		ar[arr[i]]++;
	}
	for (int i = 0; i < 42; i++)
	{
		if (ar[i])count++;
	}
	cout << count << "\n";



	return 0;
}