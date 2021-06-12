#Level 2 멀쩡한 사각형.py
def solution(w,h):
    square = 0
    #(0,0)~(w,h)
    #y = h/w x
    if w==h : 
        return w*h-w
    elif w==1 or h==1 :
        return 0
    for i in range(w) : 
        square += (int)((h*i)/w)
    return square*2
