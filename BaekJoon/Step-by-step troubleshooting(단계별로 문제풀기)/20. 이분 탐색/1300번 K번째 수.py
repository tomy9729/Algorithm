#1300번 K번째 수
def num_k(n, k) :
  start = 1 
  end = n*n
  mid = (start + end)//2

  while start <= end : 
    count = 0
    for i in range(1,n+1) : 
      if i*n <= mid : 
        count += n
      else : 
        count += mid//i
    if count < k : 
      start = mid + 1 
    else : 
      end = mid - 1
    mid = (start+end)//2
  return start

if __name__ == "__main__":
  n = int(input())
  k = int(input())

  b = [0]
  print(num_k(n,k))
