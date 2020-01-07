#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{

	int N;
	scanf("%d ", &N);

	int t = 0;

	for (int i = 0; i < N; i++)
	{
		printf("%d\n", i + 1);
	}

	return 0;
}