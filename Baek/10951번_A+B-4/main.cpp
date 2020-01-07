#include <iostream>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a = 1, b = 1;
	while (cin >> a >> b)
	{
		cout << a + b << "\n";
	}
	return 0;
}