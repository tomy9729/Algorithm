#include <stdio.h>

int main()
{

	int A, B;

	scanf("%d %d", &A, &B);


	if (B >= 45)B -= 45;
	else
	{
		if (A == 0)
		{
			A = 23;
		}
		else A--;
		B = 60 - (45 - B);
	}

	printf("%d %d\n", A, B);
	return 0;
}
