#15829번 Hashing
if __name__ == "__main__":
  r = 31
  m = 1234567891
  l = int(input())
  string = input()
  result = 0
  for i in range(l) : 
    num = int(ord(string[i]))-96
    result += num*(31**i)
    result %= m
  print(result)
