#1085번 직사각형에서 탈출
x,y,w,h = input().split()
x = int(x)
y = int(y)
w = int(w)
h = int(h)

print(min(abs(x-w),x,y,abs(y-h)))
