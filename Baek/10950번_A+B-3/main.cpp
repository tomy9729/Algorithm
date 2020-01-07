#include <stdio.h>

int main()
{

	int N;
	scanf("%d ", &N);
	int a, b;

	int *c = (int*)malloc(sizeof(int)*N);

	for (int i = 0; i < N; i++)
	{
		scanf("%d %d", &a, &b);
		c[i] = a + b;
	}

	for (int i = 0; i < N; i++)
	{
		printf("%d\n", c[i]);
	}
	return 0;
}