#include <stdio.h>

int main()
{

	int a, b;

	scanf("%d %d", &a, &b);

	int c, d, e;

	c = b % 10;

	e = b / 100;
	d = b / 10 - e * 10;
	int f, g, h;

	f = a * c;
	g = a * d;
	h = a * e;

	int i;
	i = f + g * 10 + h * 100;

	printf("%d\n%d\n%d\n%d\n", f, g, h, i);

	return 0;
}
