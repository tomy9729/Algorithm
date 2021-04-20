#Level 1 직사각형 별찍기.py 
a, b = map(int, input().strip().split(' '))
for i in range(b) : 
    for j in range(a) : 
        print("*",end='')
    print()
