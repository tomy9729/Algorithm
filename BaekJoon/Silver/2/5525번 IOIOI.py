#5525번 IOIOI 
if __name__ == "__main__":
  n = int(input())
  m = int(input())
  s = input()

  answer = 0
  pattern = 0
  i = 0
  while i < m-2 : 
    if s[i] == "I" and s[i+1] == "O" and s[i+2] == "I" : 
      pattern += 1
      if pattern == n : 
        answer += 1
        pattern -= 1
      i += 2
    else : 
      pattern = 0
      i += 1
  print(answer)
