#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;
	int a, b;

	for (int i = 0; i < N; i++)
	{
		cin >> a >> b;
		cout << "Case #" << i + 1 << ": " << a + b << "\n";
	}

	return 0;
}