#include <stdio.h>

int main()
{

	int N;
	scanf("%d ", &N);

	int t = 0;

	for (int i = 0; i <= N; i++)
	{
		t += i;
	}

	printf("%d", t);
	return 0;
}