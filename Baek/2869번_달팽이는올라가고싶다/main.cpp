#include <iostream>
#include <string>
#include <vector>
#include<cstring>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int A, B, V;

	cin >> A >> B >> V;

	int n = 0;
	int day;


	day = (V - A) / (A - B) + 1;

	if ((V - A) % (A - B))
	{
		day++;
	}

	cout << day;


	return 0;
}
